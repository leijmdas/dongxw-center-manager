package cn.kunlong.center.api.transformer;

import cn.kunlong.center.api.ITransformer;
import cn.kunlong.center.api.model.SysShortlinkDTO;
import cn.kunlong.center.biz.sys.domain.SysShortlink;
import cn.kunlong.center.core.util.BeanMapper;

public class SysShortlinkTransformer implements ITransformer<SysShortlink,SysShortlinkDTO>{
	public static final SysShortlinkTransformer INSTANCE = new SysShortlinkTransformer();
	public SysShortlinkDTO produce(SysShortlink t) {
		return BeanMapper.getInstance().map(t, SysShortlinkDTO.class);
	}
	@Override
	public SysShortlink consume(SysShortlinkDTO r) {
		return BeanMapper.getInstance().map(r, SysShortlink.class);
	}
	
}
