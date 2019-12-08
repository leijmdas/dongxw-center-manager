package cn.integriti.center.biz.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.hbatis.orm.mapper.HbatisMapper;

import cn.integriti.center.biz.sys.domain.SysUser;

/**
 * SysUserMapper
 * 
 * @author generator
 * @date 2015年12月05日
 */
public interface SysUserMapper extends HbatisMapper<SysUser, Integer> {

	List<SysUser> findByQueryParam(@Param("queryParam") SysUser.QueryParam param);

	long countByQueryParam(@Param("queryParam") SysUser.QueryParam param);
	
	/**
	 * 查询流程相关主官用户
	 * @param userId
	 * @param processCode
	 * @return
	 */
	List<SysUser> findProcessUserOfOrg(@Param("orgId")Integer orgId, @Param("processCode")String processCode);

	/**
	 * 查询关联组织结构信息
	 * @param userId
	 * @return
	 */
	SysUser findWithOrgByUserId(@Param("userId")Integer userId);
	
	
	List<SysUser> findByKeywords(@Param("corpId")Integer corpId,@Param("userId")Integer userId, @Param("keywords")String keywords);

	@Select({"select user_id from t_sys_user_role sur,t_sys_role sr where sur.role_id=sr.id and sr.corp_id=${corpId} and sr.role_code=#{roleCode}"})
	List<Integer> findUserIdsByRoleCode(@Param("corpId")Integer corpId, @Param("roleCode")String roleCode);

}