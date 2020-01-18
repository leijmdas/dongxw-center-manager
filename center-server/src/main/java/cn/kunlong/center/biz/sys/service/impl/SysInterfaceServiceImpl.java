package cn.kunlong.center.biz.sys.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.client.InvocationCallback;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyWebTarget;
import org.mybatis.hbatis.orm.criteria.Restrictions;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.kunlong.center.biz.listener.JobExceptionEvent;
import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.dao.SysInterfaceMapper;
import cn.kunlong.center.biz.sys.dao.SysInterfaceTriggerMapper;
import cn.kunlong.center.biz.sys.domain.SysDomain;
import cn.kunlong.center.biz.sys.domain.SysInterface;
import cn.kunlong.center.biz.sys.domain.SysInterfaceTrigger;
import cn.kunlong.center.biz.sys.domain.SysJobTrigger;
import cn.kunlong.center.biz.sys.queryParam.SysInterfaceParam;
import cn.kunlong.center.biz.sys.service.SysDomainService;
import cn.kunlong.center.biz.sys.service.SysInterfaceParamService;
import cn.kunlong.center.biz.sys.service.SysInterfaceService;

/**
 * SysInterfaceServiceImpl
 * 
 * @author generator
 * @date 2016年06月06日
 */
@Service
public class SysInterfaceServiceImpl implements SysInterfaceService {
	private static final Logger logger = LoggerFactory.getLogger(SysInterfaceServiceImpl.class);

	@Autowired
	private SysInterfaceMapper repo;

	@Autowired
	private SysInterfaceTriggerMapper sysInterfaceTriggerMapper;

	@Autowired
	private SysInterfaceParamService sysInterfaceParamService;

	@Autowired
	private SysDomainService sysDomainService;

	@Autowired
	private ApplicationContext applicationContext;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysInterface entity) {
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		entity.setCreateBy(entity.getUpdateBy());
		entity.setCreateOn(entity.getUpdateOn());
		repo.insert(entity);
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	public void update(SysInterface entity) {
		entity.setUpdateBy(CurrentRequestContext.getOpBy());
		entity.setUpdateOn(new Date());
		repo.update(entity);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(Integer pk) {
		repo.deleteByPK(pk);
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysInterface findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysInterface
	 * @return
	 */
	public List<SysInterface> findByNotNullProps(SysInterface entity) {

		SelectStatement<SysInterface> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysInterface
	 * @return
	 */
	public void updateNotNullPropsById(SysInterface entity) {

		UpdateStatement<SysInterface> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysInterface> findByQueryParam(SysInterfaceParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysInterfaceParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	@Override
	public List<SysJobTrigger> findTriggerByInterface(SysInterfaceParam queryParam) {
		return this.repo.findTriggerByInterface(queryParam);
	}

	@Transactional
	@Override
	public void assignTriggers(Integer id, List<Integer> triggerIds) {
		SysInterfaceTrigger.EntityNode n = SysInterfaceTrigger.EntityNode.INSTANCE;
		Restrictions<SysInterfaceTrigger> rs = StatementBuilder.buildRestrictions(n);
		rs.add(n.interfaceId.eq(id));
		this.sysInterfaceTriggerMapper.deleteByRestrictions(rs);

		if (triggerIds == null || triggerIds.isEmpty()) {
			return;
		}
		List<SysInterfaceTrigger> list = new ArrayList<SysInterfaceTrigger>();
		Integer opBy = CurrentRequestContext.getOpBy();
		for (Integer triggerId : triggerIds) {
			SysInterfaceTrigger it = new SysInterfaceTrigger();
			it.setCreateBy(opBy);
			it.setCreateOn(new Date());
			it.setInterfaceId(id);
			it.setTriggerId(triggerId);
			it.setUpdateBy(opBy);
			it.setUpdateOn(new Date());
			list.add(it);

		}
		this.sysInterfaceTriggerMapper.batchInsert(list);
	}

	@Override
	public List<SysInterface> findByTriggerId(Integer triggerId, Byte... status) {
		return this.repo.findByTriggerId(triggerId, status.length > 0 ? Arrays.asList(status) : null);
	}

	@Override
	public void invokeService(final SysInterface intf) {
		logger.info("[开始]调用接口[名称:{},requestUrl:{}]", intf.getIntfName(), intf.getRequestUrl());
		long startTime = System.currentTimeMillis();

		SysDomain domain = sysDomainService.findById(intf.getDomainId());
		Assert.notNull(domain, "域不存在");
		// TODO MODIFY LATER
		String url = domain.getDomainUrl();

		cn.kunlong.center.biz.sys.domain.SysInterfaceParam param = new cn.kunlong.center.biz.sys.domain.SysInterfaceParam();
		param.setInterfaceId(intf.getId());
		List<cn.kunlong.center.biz.sys.domain.SysInterfaceParam> paramList = this.sysInterfaceParamService.findByNotNullProps(param);

		Response rsp;
		JerseyClient client = null;

		client = new HttpClient();
		client.property(ClientProperties.CONNECT_TIMEOUT, intf.getRequestTimeout() * 1000);

		JerseyWebTarget target = client.target(url).path(intf.getRequestUrl());

		Map<String, Object> params = new HashMap<String, Object>();
		for (cn.kunlong.center.biz.sys.domain.SysInterfaceParam p : paramList) {
			target = target.queryParam(p.getParamKey(), p.getParamVal());
			params.put(p.getParamKey(), p.getParamVal());
		}
		logger.info("接口参数[url:{},params:{}]", url, params);
		if (intf.getInvokeType().equals((byte) 0)) { // 同步调用
			try {
				rsp = target.request().get();
				handleResponse(rsp, intf, applicationContext);
			} finally {
				if (client != null) {
					try {
						client.close();
					} catch (Exception ex) {
					}
				}
			}
		} else {
			// if(intf.getInvokeReceipt().equals((byte)1)){ //如果接收回执
			// Future<Response> f = target.request().async().get();
			// this.getHttpQueue().add(new HttpTask(intf.getIntfName(), client,
			// f));
			// } else {
			// try {
			// target.request().async().get();
			// } finally {
			// if (client != null) {
			// try {
			// client.close();
			// } catch (Exception ex) {
			// }
			// }
			// }
			// }
			target.request().async().get(new InvocationCallback<Response>() {

				@Override
				public void completed(Response response) {
					handleResponse(response, intf, applicationContext);
				}

				@Override
				public void failed(Throwable throwable) {
					applicationContext.publishEvent(new JobExceptionEvent(new RuntimeException("调用接口异常:"+intf.getIntfName(),throwable)));
				}

			});
		}
		//ps:非真正完成
		logger.info("[完成]调用接口[名称:{},耗时:{} ms]",intf.getIntfName(),(System.currentTimeMillis()-startTime));
	}

	public static void handleResponse(Response rsp,SysInterface intf,ApplicationContext applicationContext){
		if (rsp.getStatus() != 200) {
		
			String readEntity = (String)(rsp.getEntity());
			logger.warn("调用接口异常[名称:{}, StatusCode:{}].----响应 -----\n", intf.getIntfName(), rsp.getStatus(), readEntity);
			String msg = String.format("调用接口异常[名称:%s, StatusCode:%s].----响应 -----\n%s", intf.getIntfName(), rsp.getStatus(), readEntity);
			applicationContext.publishEvent(new JobExceptionEvent(new Exception(msg)));
		}
	}

	public static void main(String[] args) {

		HttpClient client = new HttpClient();
		client.property(ClientProperties.CONNECT_TIMEOUT, 3000);

		JerseyWebTarget target = client.target("http://mediamanager.modernavenue.com").path("/public/scheduler/order/sync_realtime");

		String s = target.request().get(String.class);
		logger.info("接口参数[params:{}]", s);

	}

	static LinkedBlockingQueue<HttpTask> HTTPQUEUE = null;

	static class HttpTask {
		private String name;
		private JerseyClient client;
		private Future<Response> future;

		public JerseyClient getClient() {
			return client;
		}

		public Future<Response> getFuture() {
			return future;
		}

		public String getName() {
			return name;
		}

		public HttpTask(String name, JerseyClient client, Future<Response> f) {
			this.name = name;
			this.client = client;
			this.future = f;
		}
	}


	static class HttpClient extends JerseyClient {
		public HttpClient() {
			this.register(new ClientRequestFilter() {

				@Override
				public void filter(ClientRequestContext requestContext) throws IOException {
					requestContext.getHeaders().putSingle("Authorization", 1);
				}

			});
		}

		public HttpClient(final Configuration config, final SSLContext sslContext, final HostnameVerifier verifier) {
			super(config, sslContext, verifier);
			this.register(new ClientRequestFilter() {

				@Override
				public void filter(ClientRequestContext requestContext) throws IOException {
					requestContext.getHeaders().putSingle("Authorization", 1);
				}

			});

		}
	}
}
