package cn.integriti.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.integriti.center.biz.sys.domain.SysUserRole;

/**
 * SysUserRoleMapper
 * @author generator
 * @date 2015年12月05日
 */
public interface SysUserRoleMapper extends HbatisMapper<SysUserRole, Integer> {

	List<SysUserRole> findByQueryParam(@Param("queryParam") SysUserRole.QueryParam queryParam);
}