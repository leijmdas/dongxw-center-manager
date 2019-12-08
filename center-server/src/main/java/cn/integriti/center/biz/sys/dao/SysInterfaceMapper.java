package cn.integriti.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.integriti.center.biz.sys.domain.SysInterface;
import cn.integriti.center.biz.sys.domain.SysJobTrigger;
import cn.integriti.center.biz.sys.queryParam.SysInterfaceParam;
/**
 * SysInterfaceMapper
 * @author generator
 * @date 2016年06月06日
 */
public interface SysInterfaceMapper extends HbatisMapper<SysInterface, Integer> {
	
	List<SysInterface> findByQueryParam(@Param("queryParam")SysInterfaceParam queryParam);
	long countByQueryParam(@Param("queryParam")SysInterfaceParam queryParam);
	List<SysJobTrigger> findTriggerByInterface(@Param("queryParam") SysInterfaceParam queryParam);
	List<SysInterface> findByTriggerId(@Param("triggerId")Integer triggerId,@Param("statusList")List<Byte> statusList);

}