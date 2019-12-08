package cn.integriti.center.api.transformer;

import cn.integriti.center.api.ITransformer;
import cn.integriti.center.api.model.SysOrgDTO;
import cn.integriti.center.biz.sys.domain.SysOrg;
import cn.integriti.center.core.util.BeanMapper;

public class SysOrgTransformer implements ITransformer<SysOrg,SysOrgDTO>{
	public static final SysOrgTransformer INSTANCE = new SysOrgTransformer();
	public SysOrgDTO produce(SysOrg t) {
		return BeanMapper.getInstance().map(t, SysOrgDTO.class);
	}
	@Override
	public SysOrg consume(SysOrgDTO r) {
		return BeanMapper.getInstance().map(r, SysOrg.class);
	}
	
}
