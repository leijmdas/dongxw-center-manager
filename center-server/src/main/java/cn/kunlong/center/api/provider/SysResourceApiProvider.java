package cn.kunlong.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.kunlong.center.api.DTFactory;
import cn.kunlong.center.api.dto.queryParam.SysResourceQueryDTO;
import cn.kunlong.center.api.model.SysResourceDTO;
import cn.kunlong.center.api.model.SysResourceGroupDTO;
import cn.kunlong.center.api.service.SysResourceApiService;
import cn.kunlong.center.api.transformer.SysResourceGroupTransformer;
import cn.kunlong.center.api.transformer.SysResourceTransformer;
import cn.kunlong.center.biz.sys.domain.SysResource;
import cn.kunlong.center.biz.sys.domain.SysResourceGroup;
import cn.kunlong.center.biz.sys.service.SysResourceService;
import cn.kunlong.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysResourceApiProvider implements SysResourceApiService {

	@Autowired
	private SysResourceService service;
	private static final SysResourceTransformer T = DTFactory.getInstance(SysResourceTransformer.class);
	
	@Override
	public PageResult<SysResourceDTO> query(SysResourceQueryDTO qpDTO) {
		cn.kunlong.center.biz.sys.domain.SysResource.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.kunlong.center.biz.sys.domain.SysResource.QueryParam.class);
		List<SysResource> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysResourceDTO> page = new PageResult<SysResourceDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public List<SysResourceGroupDTO> findAllResources() {
		List<SysResourceGroup> list = this.service.queryGroupAndResources();
		return DTFactory.getInstance(SysResourceGroupTransformer.class).produces(list);
	}

}
