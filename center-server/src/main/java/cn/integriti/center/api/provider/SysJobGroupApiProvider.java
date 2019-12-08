package cn.integriti.center.api.provider;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;


import app.support.query.PageResult;
import cn.integriti.center.api.DTFactory;
import cn.integriti.center.api.dto.queryParam.SysJobGroupQueryDTO;
import cn.integriti.center.api.model.SysJobGroupDTO;
import cn.integriti.center.api.service.SysJobGroupApiService;
import cn.integriti.center.api.transformer.SysJobGroupTransformer;
import cn.integriti.center.biz.sys.domain.SysJobGroup;
import cn.integriti.center.biz.sys.service.SysJobGroupService;
import cn.integriti.center.core.util.BeanMapper;
import io.swagger.models.auth.In;
@Service(version = "${dubbo.service.version}")
public class SysJobGroupApiProvider implements SysJobGroupApiService {

	@Autowired
	private SysJobGroupService service;
	
	private static final SysJobGroupTransformer T = DTFactory.getInstance(SysJobGroupTransformer.class);
	
	@Override
	public PageResult<SysJobGroupDTO> query(SysJobGroupQueryDTO qpDTO) {
		cn.integriti.center.biz.sys.domain.SysJobGroup.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.integriti.center.biz.sys.domain.SysJobGroup.QueryParam.class);
		List<SysJobGroup> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysJobGroupDTO> page = new PageResult<SysJobGroupDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public Integer save(SysJobGroupDTO entityDTO) {
		SysJobGroup entity = T.consume(entityDTO);
		entity.setCreateOn(new Date());
		if(entity.getId() == null) {
			this.service.save(entity);
		} else {
			SysJobGroup tmp = this.service.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			tmp.setUpdateOn(new Date());
			this.service.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public SysJobGroupDTO findById(Integer id) {
		SysJobGroup tmp = this.service.findById(id);
		return T.produce(tmp);
	}

	@Override
	public boolean delete(Integer id) {
		this.service.deleteById(id);
		return true;
	}

	@Override
	public List<SysJobGroupDTO> findByIds(List<Integer> ids) {
		List<SysJobGroup> suList = this.service.findByIds(ids);
		return T.INSTANCE.produces(suList);
	}

	@Override
	public Integer update(SysJobGroupDTO entityDTO) {
		SysJobGroup entity = T.consume(entityDTO);
		SysJobGroup tmp = this.service.findById(entity.getId());
		BeanMapper.getInstance().map(entity, tmp);
		this.service.update(tmp);
		return entity.getId();
	}

	

	/*@Override
	public void update(SysJobGroupDTO entityDTO) {
		SysJobGroup entity = T.consume(entityDTO);
		this.service.update(entity);
	}*/

	/*@Override
	public List<Integer> findResourceIds(Integer id) {
		return this.service.findResourceIds(id);
	}*/

	/*@Override
	public void assignRoleResources(Integer id, List<Integer> resIds) {
		this.service.assignRoleResources(id, resIds);
	}*/
}
