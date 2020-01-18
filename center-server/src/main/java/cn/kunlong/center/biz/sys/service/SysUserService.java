package cn.kunlong.center.biz.sys.service;

import java.util.List;

import cn.kunlong.center.biz.sys.domain.SysPosition;
import cn.kunlong.center.biz.sys.domain.SysResourceGroup;
import cn.kunlong.center.biz.sys.domain.SysUser;
/**
 * SysUserService
 * @author generator
 * @date 2015年12月05日
 */
public interface SysUserService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysUser entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysUser entity);
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk);
	
	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysUser findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysUser
	 * @return
	 */
	public List<SysUser> findByNotNullProps(SysUser entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysUser
	 * @return
	 */
	public void updateNotNullPropsById(SysUser entity);
	

	public void updatePwd(Integer id, String oldPwd, String password);

	public List<SysUser> findByQueryParam(SysUser.QueryParam queryParam);

	public long countByQueryParam(SysUser.QueryParam queryParam);
	
	
	List<SysPosition> findUserPositions(Integer userId);
	
	List<SysResourceGroup> findUserResources(Integer userId);

	/**
	 * 通过用户查询角色ids
	 * @param userId
	 * @param Type
	 * @return
	 */
	public List<Integer> findRoleIds(Integer userId, Integer type);

	/**
	 * 分配用户角色
	 * @param userId
	 * @param roleType 
	 * @param roleIds
	 */
	void assignRoles(Integer userId, Integer roleType, List<Integer> roleIds);

	/**
	 * 分配用户岗位
	 * @param id
	 * @param idList3
	 */
	public void assignPositions(Integer id, List<Integer> idList3);

	public List<SysUser> findByIds(List<Integer> userIds);

	/**
	 * 查询流程主管
	 * @param reportorId
	 * @param processCode
	 * @return
	 */
	public List<SysUser> findProcessUserOfOrg(Integer orgId, String processCode);

	/**
	 * 查询用户信息关联组织结构
	 * @param parseInt
	 * @return
	 */
	public SysUser findWithOrgByUserId(Integer userId);
	
	/**
	 * 查询企业用户
	 * @param corpId
	 * @param employeeNo
	 * @return
	 */
	public SysUser findByUsername(Integer corpId, String username);
	public List<SysUser> findByKeywords(Integer corpId,Integer userId, String keywords);

	public List<Integer> findUserIdsByRoleCode(Integer corpId, String roleCode);
	
	/**
	 * 较验密码
	 * @param corpId
	 * @param username
	 * @param password
	 * @return
	 */
	public SysUser checkPass(Integer corpId, String username, String password);

	/**
	 * 修改密码
	 * @param userId
	 * @param oldPass
	 * @param newPass
	 * @return
	 */
	public SysUser modifyPass(Integer userId, String oldPass, String newPass);

}
