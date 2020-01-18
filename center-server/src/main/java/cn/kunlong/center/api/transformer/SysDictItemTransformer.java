package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysDictItemDTO;
import cn.kunlong.center.biz.sys.domain.SysDictItem;
import cn.kunlong.center.core.util.BeanMapper;

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
