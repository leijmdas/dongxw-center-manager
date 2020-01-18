package cn.kunlong.center.biz.sys.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.kunlong.center.biz.sys.domain.SysInterfaceTrigger;

/**
 * SysInterfaceTriggerMapper
 * @author generator
 * @date 2016年06月06日
 */
public interface SysInterfaceTriggerMapper extends HbatisMapper<SysInterfaceTrigger, Integer> {
	long deleteTriggerIdInterfaceId(@Param("sysInterfaceTrigger")SysInterfaceTrigger sysInterfaceTrigger);
}