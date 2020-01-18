package cn.kunlong.center.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ValidationException;

import org.mybatis.hbatis.orm.criteria.Restrictions;
import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.dao.SysOrgMapper;
import cn.kunlong.center.biz.sys.domain.SysOrg;
import cn.kunlong.center.biz.sys.service.SysOrgService;
import cn.kunlong.center.core.enums.StatusEnum;
import cn.kunlong.center.core.support.tree.TreeNode;
import cn.kunlong.center.core.util.CollectionUtil;

/**
 * SysOrgServiceImpl
 * 
 * @author generator
 * @date 2015年12月05日
 */
@Service
public class SysOrgServiceImpl implements SysOrgService {

	@Autowired
	private SysOrgMapper repo;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	public void save(SysOrg entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		entity.setCreateBy(CurrentRequestContext.getOpBy());
		entity.setCreateOn(new Date());
		entity.setOrgPath("");
		entity.setOrderNum(0);
		this.checkEntity(entity);
		repo.insert(entity);
		this.flushDeptPath(entity.getId());
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	@Transactional
	public void update(SysOrg entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		this.checkEntity(entity);

		SysOrg tmp = this.findById(entity.getPid());
		if (tmp != null && tmp.getOrgPath().contains(":" + entity.getId())) {
			throw new RuntimeException("不能将当前组织或当前组织的下级作为其上级组织");
		}
		String oldIdPath = this.getDeptIdPathsStr(entity.getId());
		entity.setOrgPath(oldIdPath);
		repo.update(entity);

		String path = this.flushDeptPath(entity.getId());

		this.repo.replacePath(oldIdPath, path);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	@Transactional
	public void deleteById(Integer pk) {
		SysOrg org = this.findById(pk);
		Assert.isTrue(org.getPid() != null && org.getPid() >= 0, "根组织不允许删除");
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		Restrictions<SysOrg> rs = StatementBuilder.buildRestrictions(n);
		rs.add(n.orgPath.like(org.getOrgPath() + "%"));
		this.repo.deleteByRestrictions(rs);
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysOrg findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysOrg
	 * @return
	 */
	public List<SysOrg> findByNotNullProps(SysOrg entity) {

		SelectStatement<SysOrg> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysOrg
	 * @return
	 */
	public void updateNotNullPropsById(SysOrg entity) {

		UpdateStatement<SysOrg> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysOrg> findAllAvaliable() {
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		SelectStatement<SysOrg> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.status.eq(StatusEnum.ENABLE.getValue()));
		return this.repo.selectByStatement(st);
	}

	@Override
	public TreeNode<SysOrg> getRootNode(Integer corpId) {
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		SelectStatement<SysOrg> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.status.eq(StatusEnum.ENABLE.getValue())).add(n.corpId.eq(corpId));

		List<SysOrg> depts = this.repo.selectByStatement(st);
		return TreeBuilder.buildRootNode(depts);
	}

	@Override
	public TreeNode<SysOrg> buildTreeNode(List<SysOrg> depts) {
		return TreeBuilder.buildRootNode(depts);
	}

	@Override
	public List<SysOrg> findByQueryParam(SysOrg.QueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysOrg.QueryParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	private void checkEntity(SysOrg entity) {

		SysOrg tmp = this.findByPidAndDeptname(entity.getPid(), entity.getOrgName());
		if (tmp != null && !tmp.getId().equals(entity.getId())) {
			throw new ValidationException("同部门层级下部门名称已存在下[部门名称:" + entity.getOrgName() + "]");
		}
	}

	private SysOrg findByPidAndDeptname(Integer pid, String orgName) {
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		SelectStatement<SysOrg> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.pid.eq(pid)).add(n.orgName.eq(orgName));
		return CollectionUtil.uniqueResult(this.repo.selectByStatement(st));
	}

	private List<Integer> getDeptIdPaths(Integer deptId) {
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		SelectStatement<SysOrg> st = StatementBuilder.buildSelect(n);

		st.restrictions().add(n.id.eq(deptId));
		List<SysOrg> list = this.repo.selectByStatement(st);

		SysOrg dept = CollectionUtil.uniqueResult(list);
		if (dept == null) {
			return null;
		}
		List<Integer> rs = new ArrayList<Integer>();
		rs.add(dept.getId());
		if (dept.getPid() != null && dept.getPid() > 0) {
			List<Integer> ids = getDeptIdPaths(dept.getPid());
			if (ids != null && ids.size() > 0) {
				rs.addAll(ids);
			}
		}
		return rs;
	}

	private String getDeptIdPathsStr(Integer deptId) {
		List<Integer> ids = this.getDeptIdPaths(deptId);

		StringBuilder sb = new StringBuilder();
		for (int i = ids.size() - 1; i >= 0; i--) {
			sb.append(":").append(ids.get((i)));
		}
		return sb.append(":").toString();
	}

	public String flushDeptPath(Integer deptId) {
		String path = getDeptIdPathsStr(deptId);
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		UpdateStatement<SysOrg> st = StatementBuilder.buildUpdate(n);
		st.restrictions().add(n.id.eq(deptId));
		st.addField(n.orgPath, path);
		this.repo.updateByStatement(st);
		return path;
	}

	@Override
	public List<String[]> importOrgs(List<String> items) {
		if (items == null || items.isEmpty()){
			return null;
		}
		List<String[]> rs = new ArrayList<String[]>();
		
		for (String item : items) {
			try {
				this.findOrSaveDeptPath(item);
			} catch (Exception e) {
				rs.add(new String[]{item,e.getMessage()});
				
			}
		}
		return rs;
	}

	private SysOrg findOrSaveDeptPath(int pid, String deptName) {
		SysOrg d = findByPidAndDeptname(pid, deptName);
		if (d == null) {
			d = new SysOrg();
			d.setOrgName(deptName);
			d.setPid(pid);
			d.setOrderNum(0);
			d.setStatus(StatusEnum.ENABLE.getValue());
			d.setRemark("");
			this.save(d);
		}
		return d;
	}

	public SysOrg findOrSaveDeptPath(String deptPath) {
		SysOrg result = null;
		String[] deptNames = StringUtils.trimAllWhitespace(deptPath).split("(\\/)|(\\|)");
		int pid = 0;
		for (String deptName : deptNames) {
			result = this.findOrSaveDeptPath(pid, deptName);
			pid = result.getId();
		}

		return result;
	}

	/**
	 * 建树(非大量数据适用)
	 * 
	 * @author zz
	 *
	 */
	public static class TreeBuilder {

		public static TreeNode<SysOrg> buildRootNode(List<SysOrg> deptList) {
			if (deptList == null || deptList.size() < 1)
				return null;

			Integer minId = Integer.MAX_VALUE;
			Map<String, TreeNode<SysOrg>> tagNodeMap = new HashMap<String, TreeNode<SysOrg>>();

			for (SysOrg c : deptList) {
				if (c.getPid() != null) {
					if (c.getPid() == 0 && c.getId() < minId) {
						minId = c.getId();
					}
					if (c.getPid().intValue() > 0 && (c.getPid().intValue() < minId)) {
						minId = c.getPid();
					}

				}

				TreeNode<SysOrg> cNode = new TreeNode<SysOrg>();
				cNode.setId(c.getId().toString());
				cNode.setParentId(c.getPid().toString());
				cNode.setNodeVal(c);
				cNode.setText(c.getOrgName());
				tagNodeMap.put(c.getId().toString(), cNode);

			}
			String rootCode = "" + minId;
			TreeNode<SysOrg> rootNode = tagNodeMap.get(rootCode);
			if (rootNode == null) {
				// 根节点，数据库未存
				TreeNode<SysOrg> cNode = new TreeNode<SysOrg>();
				cNode.setId("0");
				cNode.setParentId("-1");
				cNode.setText("组织结构根");
				tagNodeMap.put("0", cNode);
				rootCode = "0";
			}
			for (SysOrg c : deptList) {
				String pCode = c.getPid() == null ? null : c.getPid().toString();
				if (pCode != null) {
					TreeNode<SysOrg> pNode = tagNodeMap.get(pCode);
					if (pNode != null) {
						if (pNode.getChildren() == null) {
							pNode.setChildren(new ArrayList<TreeNode<SysOrg>>());
						}

						// 排序
						int index = 0;
						for (TreeNode<SysOrg> tmp : pNode.getChildren()) {
							if (tmp.getNodeVal().getOrderNum() < c.getOrderNum() || (tmp.getNodeVal().getOrderNum() == c.getOrderNum() && tmp.getNodeVal().getOpOn().after(c.getOpOn()))) {
								index++;
							}
						}
						pNode.getChildren().add(index, tagNodeMap.get(c.getId().toString()));

					}
				}
			}
			return tagNodeMap.get(rootCode);
		}

	}

	@Override
	public List<SysOrg> findMicroList(SysOrg.QueryParam qp) {
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		SelectStatement<SysOrg> st = StatementBuilder.buildSelect(n);
		if (qp.getIds() != null && !qp.getIds().isEmpty()) {
			st.getRestrictions().add(n.id.in(qp.getIds()));
		} else {
			return this.findByQueryParam(qp);
		}
		return repo.selectByStatement(st);
	}

	@Override
	public List<SysOrg> findByIds(List<Integer> orgIds) {
		SysOrg.EntityNode n = SysOrg.EntityNode.INSTANCE;
		SelectStatement<SysOrg> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.id.in(orgIds));
		return this.repo.selectByStatement(st);
	}

}
