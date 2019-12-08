package cn.integriti.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import org.springframework.web.bind.annotation.PathVariable;

import cn.integriti.center.biz.sys.domain.SysJobTrigger;
import cn.integriti.center.biz.sys.queryParam.SysJobTriggerParam;
/**
 * SysJobTriggerMapper
 * @author generator
 * @date 2016年06月01日
 */
public interface SysJobTriggerMapper extends HbatisMapper<SysJobTrigger, Integer> {
	List<SysJobTrigger> findByQueryParam(@Param("queryParam")SysJobTriggerParam queryParam);
	long countByQueryParam(@Param("queryParam")SysJobTriggerParam queryParam);
	SysJobTrigger findJobTriggerById(@PathVariable("id") Integer id);
	int updateClause(@Param("sysJobTrigger") SysJobTrigger sysJobTrigger);
	
	List<SysJobTrigger> findAllTriggers(@Param("jobType")Integer jobType);
}