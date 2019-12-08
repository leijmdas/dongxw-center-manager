package cn.integriti.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.integriti.center.api.DTFactory;
import cn.integriti.center.api.dto.queryParam.SysResourceQueryDTO;
import cn.integriti.center.api.model.SysResourceDTO;
import cn.integriti.center.api.model.SysResourceGroupDTO;
import cn.integriti.center.api.service.SysResourceApiService;
import cn.integriti.center.api.transformer.SysResourceGroupTransformer;
import cn.integriti.center.api.transformer.SysResourceTransformer;
import cn.integriti.center.biz.sys.domain.SysResource;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.service.SysResourceService;
import cn.integriti.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysResourceApiProvider implements SysResourceApiService {

	@Autowired
	private SysResourceService service;
	private static final SysResourceTransformer T = DTFactory.getInstance(SysResourceTransformer.class);
	
	@Override
	public PageResult<SysResourceDTO> query(SysResourceQueryDTO qpDTO) {
		cn.integriti.center.biz.sys.domain.SysResource.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.integriti.center.biz.sys.domain.SysResource.QueryParam.class);
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
