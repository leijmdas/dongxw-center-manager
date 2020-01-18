package cn.kunlong.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.kunlong.center.api.DTFactory;
import cn.kunlong.center.api.dto.queryParam.SysHttpJobQueryDTO;
import cn.kunlong.center.api.model.SysHttpJobDTO;
import cn.kunlong.center.api.service.SysHttpJobApiService;
import cn.kunlong.center.api.transformer.SysHttpJobTransformer;
import cn.kunlong.center.biz.sys.domain.SysHttpJob;
import cn.kunlong.center.biz.sys.service.SysHttpJobService;
import cn.kunlong.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysHttpJobApiProvider implements SysHttpJobApiService {

	@Autowired
	private SysHttpJobService service;
	
	private static final SysHttpJobTransformer T = DTFactory.getInstance(SysHttpJobTransformer.class);
	
	@Override
	public PageResult<SysHttpJobDTO> query(SysHttpJobQueryDTO qpDTO) {
		cn.kunlong.center.biz.sys.domain.SysHttpJob.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.kunlong.center.biz.sys.domain.SysHttpJob.QueryParam.class);
		List<SysHttpJob> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysHttpJobDTO> page = new PageResult<SysHttpJobDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public Integer save(SysHttpJobDTO entityDTO) {
		SysHttpJob entity = T.consume(entityDTO);
		if(entity.getId() == null) {
			this.service.save(entity);
		} else {
			SysHttpJob tmp = this.service.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			this.service.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public SysHttpJobDTO findById(Integer id) {
		SysHttpJob tmp = this.service.findById(id);
		return T.produce(tmp);
	}

	@Override
	public boolean delete(Integer id) {
		this.service.deleteById(id);
		return true;
	}

	@Override
	public List<SysHttpJobDTO> findByIds(List<Integer> ids) {
		List<SysHttpJob> suList = this.service.findByIds(ids);
		return T.produces(suList);
	}

	@Override
	public Integer update(SysHttpJobDTO entityDTO) {
		SysHttpJob entity = T.consume(entityDTO);
		SysHttpJob tmp = this.service.findById(entity.getId());
		BeanMapper.getInstance().map(entity, tmp);
		this.service.update(tmp);
		return entity.getId();
	}


	@Override
	public Integer pause(Integer id) {
		this.service.pause(id);
		return 1;
	}

	@Override
	public Integer resume(Integer id) {
		this.service.resume(id);
		return 1;
	}

	

	
}
