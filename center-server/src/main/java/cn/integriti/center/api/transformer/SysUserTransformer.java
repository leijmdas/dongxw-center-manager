package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysUserDTO;
import cn.integriti.center.biz.sys.domain.SysUser;
import cn.integriti.center.core.util.BeanMapper;

public class SysUserTransformer implements ITransformer<SysUser,SysUserDTO>{
	public static final SysUserTransformer INSTANCE = new SysUserTransformer();
	public SysUserDTO produce(SysUser t) {
		return BeanMapper.getInstance().map(t, SysUserDTO.class);
	}
	@Override
	public SysUser consume(SysUserDTO r) {
		return BeanMapper.getInstance().map(r, SysUser.class);
	}
	
}
