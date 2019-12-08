package cn.integriti.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;
import org.springframework.web.bind.annotation.PathVariable;

import cn.integriti.center.biz.sys.domain.SysJob;
import cn.integriti.center.biz.sys.domain.SysJobTrigger;
import cn.integriti.center.biz.sys.queryParam.SysJobParam;
/**
 * SysJobMapper
 * @author generator
 * @date 2016年06月01日
 */
public interface SysJobMapper extends HbatisMapper<SysJob, Integer> {
	
	List<SysJob> findByQueryParam(@Param("queryParam")SysJobParam queryParam);
	long countByQueryParam(@Param("queryParam")SysJobParam queryParam);
	int updateClause(@Param("sysJob") SysJob sysJob);
}