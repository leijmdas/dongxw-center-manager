package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysUserDTO;
import cn.kunlong.center.biz.sys.domain.SysUser;
import cn.kunlong.center.core.util.BeanMapper;

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
