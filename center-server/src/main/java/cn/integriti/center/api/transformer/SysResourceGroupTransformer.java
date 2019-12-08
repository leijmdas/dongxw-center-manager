package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysResourceGroupDTO;
import cn.integriti.center.biz.sys.domain.SysResourceGroup;
import cn.integriti.center.core.util.BeanMapper;

public class SysResourceGroupTransformer implements ITransformer<SysResourceGroup,SysResourceGroupDTO>{
	public static final SysResourceGroupTransformer INSTANCE = new SysResourceGroupTransformer();
	public SysResourceGroupDTO produce(SysResourceGroup t) {
		return BeanMapper.getInstance().map(t, SysResourceGroupDTO.class);
	}
	@Override
	public SysResourceGroup consume(SysResourceGroupDTO r) {
		return BeanMapper.getInstance().map(r, SysResourceGroup.class);
	}
	
}
