package cn.kunlong.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.kunlong.center.biz.sys.domain.SysJob;
import cn.kunlong.center.biz.sys.queryParam.SysJobParam;
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