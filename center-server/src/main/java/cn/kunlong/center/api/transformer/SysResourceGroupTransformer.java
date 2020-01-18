package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysResourceGroupDTO;
import cn.kunlong.center.biz.sys.domain.SysResourceGroup;
import cn.kunlong.center.core.util.BeanMapper;

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
