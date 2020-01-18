package cn.kunlong.center.biz.sys.service;

import cn.kunlong.center.biz.sys.domain.SysAccount;
import java.util.List;
/**
 * SysAccountService
 * @author generator
 * @date 2018年06月11日
 */
public interface SysAccountService {
	
	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysAccount entity);

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysAccount entity);
	
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
	public SysAccount findById(Integer pk);
	/**
	 * 通过非空属性查询
	 * @param SysAccount
	 * @return
	 */
	public List<SysAccount> findByNotNullProps(SysAccount entity);
	/**
	 * 通过主键更新非空属性
	 * @param SysAccount
	 * @return
	 */
	public void updateNotNullPropsById(SysAccount entity);
	
	
	/**
	 * 通过实体参数分页查询
	 * @param SysAccount.QueryParam
	 * @return
	 */
	public List<SysAccount> findByQueryParam(SysAccount.QueryParam queryParam);
	/**
	 * 通过实体参数统计
	 * @param SysAccount.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysAccount.QueryParam queryParam);

	/**
	 * 创建一个实体
	 * @param loginName
	 * @param realName
	 * @param telNo
	 * @return
	 */
	public SysAccount create(String loginName, String realName, String telNo);

	/**
	 * 通过用户名或手机号查询
	 * @param username
	 * @return
	 */
	public SysAccount findLoginnameOrTel(String username);

	/**
	 * 通过手机号查找
	 * @param telNo
	 * @return
	 */
	public SysAccount findByTelNo(String telNo);

	public List<SysAccount> findByIds(List<Integer> accountIds);
	public List<SysAccount> findMicroList(SysAccount.QueryParam qp);

	/**
	 * 修改密码
	 * @param opBy
	 * @param oldPass
	 * @param newPass
	 */
	public void modifyPwd(Integer opBy, String oldPass, String newPass);
}
