package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysHttpJobDTO;
import cn.kunlong.center.biz.sys.domain.SysHttpJob;
import cn.kunlong.center.core.util.BeanMapper;

public class SysHttpJobTransformer implements ITransformer<SysHttpJob,SysHttpJobDTO>{
	public static final SysHttpJobTransformer INSTANCE = new SysHttpJobTransformer();
	public SysHttpJobDTO produce(SysHttpJob t) {
		return BeanMapper.getInstance().map(t, SysHttpJobDTO.class);
	}
	@Override
	public SysHttpJob consume(SysHttpJobDTO r) {
		return BeanMapper.getInstance().map(r, SysHttpJob.class);
	}
	
}
