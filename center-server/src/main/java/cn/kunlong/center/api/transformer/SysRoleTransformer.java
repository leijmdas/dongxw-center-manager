package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysRoleDTO;
import cn.kunlong.center.biz.sys.domain.SysRole;
import cn.kunlong.center.core.util.BeanMapper;

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
