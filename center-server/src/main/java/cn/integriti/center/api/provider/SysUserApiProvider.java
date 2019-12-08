package cn.integriti.center.api.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import cn.integriti.center.api.DTFactory;
import cn.integriti.center.api.dto.queryParam.SysUserQueryDTO;
import cn.integriti.center.api.model.AuthorizationDTO;
import cn.integriti.center.api.model.SysCorpDTO;
import cn.integriti.center.api.model.SysResourceGroupDTO;
import cn.integriti.center.api.model.SysRoleDTO;
import cn.integriti.center.api.model.SysUserDTO;
import cn.integriti.center.api.service.SysUserApiService;
import cn.integriti.center.api.transformer.SysUserTransformer;
import cn.integriti.center.biz.sys.domain.SysCorp;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.biz.sys.domain.SysRole;
import cn.integriti.center.biz.sys.domain.SysUser;
import cn.integriti.center.biz.sys.service.SysCorpService;
import cn.integriti.center.biz.sys.service.SysRoleService;
import cn.integriti.center.biz.sys.service.SysUserService;
import cn.integriti.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysUserApiProvider implements SysUserApiService {

	@Autowired
	private SysUserService service;
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@Autowired
	private SysCorpService sysCorpService;
	
	private static final SysUserTransformer T = DTFactory.getInstance(SysUserTransformer.class);
	
	@Override
	public PageResult<SysUserDTO> query(SysUserQueryDTO qpDTO) {
		cn.integriti.center.biz.sys.domain.SysUser.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.integriti.center.biz.sys.domain.SysUser.QueryParam.class);
		List<SysUser> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysUserDTO> page = new PageResult<SysUserDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public Integer save(SysUserDTO entityDTO) {
		SysUser entity = T.consume(entityDTO);
		if(entity.getId() == null) {
			this.service.save(entity);
		} else {
			SysUser tmp = this.service.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			this.service.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public SysUserDTO findById(Integer id) {
		SysUser tmp = this.service.findById(id);
		return T.produce(tmp);
	}

	@Override
	public void delete(Integer id) {
		this.service.deleteById(id);
	}

	@Override
	public void assignRoles(Integer id, Integer roleType, List<Integer> roleIds) {
		this.service.assignRoles(id, roleType, roleIds);
	}

	@Override
	public List<SysUserDTO> findByIds(List<Integer> userIds) {
		List<SysUser> suList = this.service.findByIds(userIds);
		return T.produces(suList);
	}

	@Override
	public SysUserDTO findByUsername(Integer corpId, String employeeNo) {
		SysUser su = this.service.findByUsername(corpId, employeeNo);
		
		return T.produce(su);
	}

	@Override
	public SysUserDTO checkPass(Integer corpId, String username, String password) {
		SysUser su = this.service.checkPass(corpId,username,password);
		
		return T.produce(su);
	}

	@Override
	public AuthorizationDTO getAuthorization(Integer userId) {
		SysUser su = this.service.findById(userId);
		
		Assert.notNull(su,"数据错误,用户不存在");
		
		List<SysRole> sysRoles = this.sysRoleService.findUserRoles(su.getId(), SysRole.TYPE_FUNCTION);

		SysUserDTO miniSU = new SysUserDTO();
		List<SysRoleDTO> roleDTOs = new ArrayList<SysRoleDTO>();
		List<SysResourceGroupDTO> resGroupDTOs = new ArrayList<SysResourceGroupDTO>();

		BeanMapper.getInstance().map(su, miniSU);

		if (sysRoles != null && sysRoles.size() > 0) {
			List<Integer> roleIds = new ArrayList<Integer>(sysRoles.size());
			for (SysRole sr : sysRoles) {
				SysRoleDTO srDTO = new SysRoleDTO();
				BeanMapper.getInstance().map(sr, srDTO);
				roleDTOs.add(srDTO);

				roleIds.add(sr.getId());
			}

			if (roleIds != null && roleIds.size() > 0) {
				List<SysResourceGroup> resGroups = this.sysRoleService.findRoleResources(roleIds);

				if (resGroups != null && resGroups.size() > 0) {
					for (SysResourceGroup resGroup : resGroups) {
						SysResourceGroupDTO tmp = new SysResourceGroupDTO();
						BeanMapper.getInstance().map(resGroup, tmp);
						resGroupDTOs.add(tmp);

					}
				}
			}
		}
		SysCorp corp = this.sysCorpService.findById(su.getCorpId());
		AuthorizationDTO az = new AuthorizationDTO();
		
		SysCorpDTO scd = new SysCorpDTO();
		scd.setId(corp.getId());
		scd.setCorpCode(corp.getCorpCode());
		scd.setCorpName(corp.getCorpName());
		az.setSysCorp(scd);
		
		
		az.setSysUser(miniSU);
		az.setSysRoles(roleDTOs);
		az.setSysResourceGroups(resGroupDTOs);
		
		return az;
	}

	@Override
	public List<Integer> findRoleIds(Integer userId, Integer type) {
		return this.service.findRoleIds(userId, type);
	}

	@Override
	public SysUserDTO modifyPass(Integer userId, String oldPass, String newPass) {
		SysUser su = this.service.modifyPass(userId,oldPass,newPass);
		return T.produce(su);
	}

}
