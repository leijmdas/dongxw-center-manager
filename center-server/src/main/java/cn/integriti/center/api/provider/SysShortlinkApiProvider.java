package cn.integriti.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.integriti.center.api.DTFactory;
import cn.integriti.center.api.dto.queryParam.SysShortlinkQueryDTO;
import cn.integriti.center.api.model.SysShortlinkDTO;
import cn.integriti.center.api.service.SysShortlinkApiService;
import cn.integriti.center.api.transformer.SysShortlinkTransformer;
import cn.integriti.center.biz.sys.domain.SysShortlink;
import cn.integriti.center.biz.sys.service.SysShortlinkService;
import cn.integriti.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysShortlinkApiProvider implements SysShortlinkApiService {

	@Autowired
	private SysShortlinkService service;
	
	private static final SysShortlinkTransformer T = DTFactory.getInstance(SysShortlinkTransformer.class);
	
	@Override
	public PageResult<SysShortlinkDTO> query(SysShortlinkQueryDTO qpDTO) {
		cn.integriti.center.biz.sys.domain.SysShortlink.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.integriti.center.biz.sys.domain.SysShortlink.QueryParam.class);
		
		List<SysShortlink> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysShortlinkDTO> page = new PageResult<SysShortlinkDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public Integer save(SysShortlinkDTO entityDTO) {
		SysShortlink entity = T.consume(entityDTO);
		if(entity.getId() == null) {
			this.service.save(entity);
		} else {
			SysShortlink tmp = this.service.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			this.service.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public SysShortlinkDTO findById(Integer id) {
		SysShortlink tmp = this.service.findById(id);
		return T.produce(tmp);
	}

	@Override
	public void delete(Integer id) {
		this.service.deleteById(id);
	}

	@Override
	public SysShortlinkDTO findByCode(String code) {
		SysShortlink tmp = this.service.findByCode(code);
		return T.produce(tmp);
	}
}
