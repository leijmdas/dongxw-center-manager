package cn.integriti.center.api.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.integriti.center.api.DTFactory;
import cn.integriti.center.api.dto.queryParam.SysRoleQueryDTO;
import cn.integriti.center.api.model.SysRoleDTO;
import cn.integriti.center.api.service.SysRoleApiService;
import cn.integriti.center.api.transformer.SysRoleTransformer;
import cn.integriti.center.biz.sys.domain.SysRole;
import cn.integriti.center.biz.sys.service.SysRoleService;
import cn.integriti.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysRoleApiProvider implements SysRoleApiService {

	@Autowired
	private SysRoleService service;
	
	private static final SysRoleTransformer T = DTFactory.getInstance(SysRoleTransformer.class);
	
	@Override
	public PageResult<SysRoleDTO> query(SysRoleQueryDTO qpDTO) {
		cn.integriti.center.biz.sys.domain.SysRole.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.integriti.center.biz.sys.domain.SysRole.QueryParam.class);
		List<SysRole> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysRoleDTO> page = new PageResult<SysRoleDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public Integer save(SysRoleDTO entityDTO) {
		SysRole entity = T.consume(entityDTO);
		if(entity.getId() == null) {
			this.service.save(entity);
		} else {
			SysRole tmp = this.service.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			this.service.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public SysRoleDTO findById(Integer id) {
		SysRole tmp = this.service.findById(id);
		return T.produce(tmp);
	}

	@Override
	public void delete(Integer id) {
		this.service.deleteById(id);
	}

	@Override
	public List<SysRoleDTO> findByIds(List<Integer> ids) {
		List<SysRole> suList = this.service.findByIds(ids);
		return T.produces(suList);
	}

	@Override
	public List<Integer> findResourceIds(Integer id) {
		return this.service.findResourceIds(id);
	}

	@Override
	public void assignRoleResources(Integer id, List<Integer> resIds) {
		this.service.assignRoleResources(id, resIds);
	}
}
