package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysResourceDTO;
import cn.integriti.center.biz.sys.domain.SysResource;
import cn.integriti.center.core.util.BeanMapper;

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
