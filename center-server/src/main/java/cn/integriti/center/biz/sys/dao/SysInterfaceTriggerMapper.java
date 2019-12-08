package cn.integriti.center.biz.sys.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.integriti.center.biz.sys.domain.SysInterfaceTrigger;
import cn.integriti.center.biz.sys.queryParam.SysInterfaceParam;
/**
 * SysInterfaceTriggerMapper
 * @author generator
 * @date 2016年06月06日
 */
public interface SysInterfaceTriggerMapper extends HbatisMapper<SysInterfaceTrigger, Integer> {
	long deleteTriggerIdInterfaceId(@Param("sysInterfaceTrigger")SysInterfaceTrigger sysInterfaceTrigger);
}