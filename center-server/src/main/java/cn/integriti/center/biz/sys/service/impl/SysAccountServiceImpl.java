package cn.integriti.center.biz.sys.service.impl;

import java.util.Date;
import java.util.List;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.integriti.center.biz.support.CurrentRequestContext;
import cn.integriti.center.biz.support.validation.BeanValidator;
import cn.integriti.center.biz.sys.dao.SysAccountMapper;
import cn.integriti.center.biz.sys.domain.SysAccount;
import cn.integriti.center.biz.sys.service.SysAccountService;
import cn.integriti.center.core.enums.StatusEnum;
import cn.integriti.center.core.util.SecurityUtil;

/**
 * SysAccountServiceImpl
 * @author generator
 * @date 2018年06月11日
 */
@Service
public class SysAccountServiceImpl implements SysAccountService {

	@Autowired
	private SysAccountMapper repo;

	private void checkEntity(SysAccount entity) {
		BeanValidator.propertyCheck(entity);
		SysAccount tmp = this.findLoginnameOrTel(entity.getLoginName());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new RuntimeException("登录名已存在");
		}
		tmp = this.findByTelNo(entity.getTelNo());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new RuntimeException("手机号已存在");
		}

	}

	/**
	 * 保存
	 * @param entity
	 */
	public void save(SysAccount entity) {
		entity.setCreateBy(CurrentRequestContext.getOpBy());
		entity.setCreateOn(new Date());
		entity.setOpOn(entity.getCreateOn());
		entity.setOpBy(entity.getCreateBy());

		this.checkEntity(entity);
		repo.insert(entity);
	}

	/**
	 * 修改
	 * @param entity
	 */
	public void update(SysAccount entity) {
		entity.setOpOn(new Date());
		entity.setOpBy(CurrentRequestContext.getOpBy());

		this.checkEntity(entity);
		repo.update(entity);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Integer pk) {
		repo.deleteByPK(pk);
	}

	/**
	 * 通过id获取
	 * @param id
	 * @return
	 */
	public SysAccount findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * @param SysAccount
	 * @return
	 */
	public List<SysAccount> findByNotNullProps(SysAccount entity) {

		SelectStatement<SysAccount> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * @param SysAccount
	 * @return
	 */
	public void updateNotNullPropsById(SysAccount entity) {

		UpdateStatement<SysAccount> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	/**
	 * 通过实体参数分页查询
	 * @param SysAccount.QueryParam
	 * @return
	 */
	public List<SysAccount> findByQueryParam(SysAccount.QueryParam queryParam) {
		return repo.findByQueryParam(queryParam);
	}

	/**
	 * 通过实体参数统计
	 * @param SysAccount.QueryParam
	 * @return
	 */
	public long countByQueryParam(SysAccount.QueryParam queryParam) {
		return repo.countByQueryParam(queryParam);
	}

	public SysAccount create(String loginName, String realName, String telNo) {
		SysAccount entity = new SysAccount();
		entity.setLoginName(loginName);
		entity.setRealName(realName);
		entity.setTelNo(telNo);

		entity.setPwdSalt("");
		entity.setPwd(SecurityUtil.md5("111111"));
		entity.setStatus(StatusEnum.ENABLE.getValue());
		this.save(entity);
		return entity;
	}

	@Override
	public SysAccount findLoginnameOrTel(String username) {
		return this.repo.findLoginnameOrTel(username);
	}

	@Override
	public SysAccount findByTelNo(String telNo) {
		SysAccount.EntityNode n = SysAccount.EntityNode.INSTANCE;
		SelectStatement<SysAccount> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.telNo.eq(telNo));
		return this.repo.selectByStatement(st).stream().findFirst().orElse(null);
	}

	@Override
	public List<SysAccount> findByIds(List<Integer> accountIds) {
		SysAccount.EntityNode n = SysAccount.EntityNode.INSTANCE;
		SelectStatement<SysAccount> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.id.in(accountIds));
		return this.repo.selectByStatement(st);
	}

	@Override
	public List<SysAccount> findMicroList(SysAccount.QueryParam qp) {
		SysAccount.EntityNode n = SysAccount.EntityNode.INSTANCE;
		SelectStatement<SysAccount> st = StatementBuilder.buildSelect(n);
		if (qp.getIds() != null && !qp.getIds().isEmpty()) {
			st.getRestrictions().add(n.id.in(qp.getIds()));
		} else {
			return this.findByQueryParam(qp);
		}
		return repo.selectByStatement(st);
	}

	@Override
	public void modifyPwd(Integer accountId, String oldPass, String newPass) {
		SysAccount account = this.repo.selectByPK(accountId);
		
//		Md5PasswordEncoder encoder = new Md5PasswordEncoder();
//		
//		if(!encoder.encodePassword(oldPass, "").equals(account.getPwd())) {
//			throw new BusinessException("pass_not_valid","旧密码不正确");
//		}
//		account.setPwd(encoder.encodePassword(newPass, ""));
		
		this.repo.update(account);
	}

}
