package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysResourceDTO;
import cn.kunlong.center.biz.sys.domain.SysResource;
import cn.kunlong.center.core.util.BeanMapper;

public class SysResourceTransformer implements ITransformer<SysResource,SysResourceDTO>{
	public static final SysResourceTransformer INSTANCE = new SysResourceTransformer();
	public SysResourceDTO produce(SysResource t) {
		return BeanMapper.getInstance().map(t, SysResourceDTO.class);
	}
	@Override
	public SysResource consume(SysResourceDTO r) {
		return BeanMapper.getInstance().map(r, SysResource.class);
	}
	
}
