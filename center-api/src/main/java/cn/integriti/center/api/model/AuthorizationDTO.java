package cn.integriti.center.api.model;

import java.io.Serializable;
import java.util.List;

public class AuthorizationDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SysCorpDTO sysCorp;
	
	private SysUserDTO sysUser;
	private List<SysRoleDTO> sysRoles;
	private List<SysResourceGroupDTO> sysResourceGroups;
	
	public SysUserDTO getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUserDTO sysUser) {
		this.sysUser = sysUser;
	}
	public List<SysRoleDTO> getSysRoles() {
		return sysRoles;
	}
	public void setSysRoles(List<SysRoleDTO> sysRoles) {
		this.sysRoles = sysRoles;
	}
	public List<SysResourceGroupDTO> getSysResourceGroups() {
		return sysResourceGroups;
	}
	public void setSysResourceGroups(List<SysResourceGroupDTO> sysResourceGroups) {
		this.sysResourceGroups = sysResourceGroups;
	}
	public SysCorpDTO getSysCorp() {
		return sysCorp;
	}
	public void setSysCorp(SysCorpDTO sysCorp) {
		this.sysCorp = sysCorp;
	}
	
}
