package cn.kunlong.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.kunlong.center.biz.sys.domain.SysJobGroup;

/**
 * SysJobGroupMapper
 * @author generator
 * @date 2016年06月05日
 */
public interface SysJobGroupMapper extends HbatisMapper<SysJobGroup, Integer> {
	List<SysJobGroup> findByQueryParam(@Param("queryParam")SysJobGroup.QueryParam queryParam);
	long countByQueryParam(@Param("queryParam")SysJobGroup.QueryParam queryParam);
	int updateClause(@Param("sysJobGroup") SysJobGroup sysJobGroup);
}