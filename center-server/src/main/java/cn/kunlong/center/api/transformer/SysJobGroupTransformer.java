package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysJobGroupDTO;
import cn.kunlong.center.biz.sys.domain.SysJobGroup;
import cn.kunlong.center.core.util.BeanMapper;

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
