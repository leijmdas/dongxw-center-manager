package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysJobGroupDTO;
import cn.integriti.center.biz.sys.domain.SysJobGroup;
import cn.integriti.center.core.util.BeanMapper;

public class SysJobGroupTransformer implements ITransformer<SysJobGroup,SysJobGroupDTO>{
	public static final SysJobGroupTransformer INSTANCE = new SysJobGroupTransformer();
	public SysJobGroupDTO produce(SysJobGroup t) {
		return BeanMapper.getInstance().map(t, SysJobGroupDTO.class);
	}
	@Override
	public SysJobGroup consume(SysJobGroupDTO r) {
		return BeanMapper.getInstance().map(r, SysJobGroup.class);
	}
	
}
