package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysDictDTO;
import cn.integriti.center.biz.sys.domain.SysDict;
import cn.integriti.center.core.util.BeanMapper;

public class SysDictTransformer implements ITransformer<SysDict,SysDictDTO>{
	public static final SysDictTransformer INSTANCE = new SysDictTransformer();
	public SysDictDTO produce(SysDict t) {
		return BeanMapper.getInstance().map(t, SysDictDTO.class);
	}
	@Override
	public SysDict consume(SysDictDTO r) {
		return BeanMapper.getInstance().map(r, SysDict.class);
	}
	
}
