package cn.kunlong.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.kunlong.center.api.DTFactory;
import cn.kunlong.center.api.dto.queryParam.SysShortlinkQueryDTO;
import cn.kunlong.center.api.model.SysShortlinkDTO;
import cn.kunlong.center.api.service.SysShortlinkApiService;
import cn.kunlong.center.api.transformer.SysShortlinkTransformer;
import cn.kunlong.center.biz.sys.domain.SysShortlink;
import cn.kunlong.center.biz.sys.service.SysShortlinkService;
import cn.kunlong.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysShortlinkApiProvider implements SysShortlinkApiService {

	@Autowired
	private SysShortlinkService service;
	
	private static final SysShortlinkTransformer T = DTFactory.getInstance(SysShortlinkTransformer.class);
	
	@Override
	public PageResult<SysShortlinkDTO> query(SysShortlinkQueryDTO qpDTO) {
		cn.kunlong.center.biz.sys.domain.SysShortlink.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.kunlong.center.biz.sys.domain.SysShortlink.QueryParam.class);
		
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
