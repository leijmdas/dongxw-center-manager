package cn.kunlong.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.kunlong.center.biz.sys.domain.SysRole;
/**
 * SysRoleMapper
 * @author generator
 * @date 2015年12月05日
 */
public interface SysRoleMapper extends HbatisMapper<SysRole, Integer> {
	
	/**
	 * 查询用户角色
	 * @param userId
	 * @param type 
	 * @return
	 */
	List<SysRole> findUserRoles(@Param("userId")Integer userId, @Param("type")Integer type);

	List<SysRole> findByQueryParam(@Param("queryParam")SysRole.QueryParam queryParam);
	
	long countByQueryParam(@Param("queryParam")SysRole.QueryParam queryParam);
}