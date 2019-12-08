package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysDictItemDTO;
import cn.integriti.center.biz.sys.domain.SysDictItem;
import cn.integriti.center.core.util.BeanMapper;

public class SysDictItemTransformer implements ITransformer<SysDictItem,SysDictItemDTO>{
	public static final SysDictItemTransformer INSTANCE = new SysDictItemTransformer();
	public SysDictItemDTO produce(SysDictItem t) {
		return BeanMapper.getInstance().map(t, SysDictItemDTO.class);
	}
	@Override
	public SysDictItem consume(SysDictItemDTO r) {
		return BeanMapper.getInstance().map(r, SysDictItem.class);
	}
	
}
