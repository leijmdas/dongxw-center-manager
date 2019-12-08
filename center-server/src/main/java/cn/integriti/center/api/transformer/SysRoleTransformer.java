package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysRoleDTO;
import cn.integriti.center.biz.sys.domain.SysRole;
import cn.integriti.center.core.util.BeanMapper;

public class SysRoleTransformer implements ITransformer<SysRole,SysRoleDTO>{
	public static final SysRoleTransformer INSTANCE = new SysRoleTransformer();
	public SysRoleDTO produce(SysRole t) {
		return BeanMapper.getInstance().map(t, SysRoleDTO.class);
	}
	@Override
	public SysRole consume(SysRoleDTO r) {
		return BeanMapper.getInstance().map(r, SysRole.class);
	}
	
}
