package cn.kunlong.center.biz.sys.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.hbatis.orm.criteria.statement.SelectStatement;
import org.mybatis.hbatis.orm.criteria.statement.UpdateStatement;
import org.mybatis.hbatis.orm.criteria.support.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import cn.kunlong.center.biz.support.CurrentRequestContext;
import cn.kunlong.center.biz.sys.dao.SysDictTreemodelMapper;
import cn.kunlong.center.biz.sys.domain.SysDictTreemodel;
import cn.kunlong.center.biz.sys.queryParam.SysDictTreemodelQueryParam;
import cn.kunlong.center.biz.sys.service.SysDictTreemodelService;
import cn.kunlong.center.core.enums.StatusEnum;
import cn.kunlong.center.core.support.tree.TreeNode;
import cn.kunlong.center.core.util.CollectionUtil;

/**
 * SysDictTreemodelServiceImpl
 * 
 * @author generator
 * @date 2015年12月27日
 */
@Service
public class SysDictTreemodelServiceImpl implements SysDictTreemodelService {

	@Autowired
	private SysDictTreemodelMapper repo;

	/**
	 * 保存
	 * 
	 * @param entity
	 */
	@Transactional
	public void save(SysDictTreemodel entity) {

		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		entity.setCreateBy(entity.getOpBy());
		entity.setCreateOn(entity.getOpOn());
		entity.setPath("");
		this.checkEntity(entity);
		repo.insert(entity);
		this.flushPath(entity.getId());

	}

	private List<Integer> getIdPaths(Integer deptId) {
		SysDictTreemodel.EntityNode n = SysDictTreemodel.EntityNode.INSTANCE;
		SelectStatement<SysDictTreemodel> st = StatementBuilder.buildSelect(n);

		st.restrictions().add(n.id.eq(deptId));
		List<SysDictTreemodel> list = this.repo.selectByStatement(st);

		SysDictTreemodel dept = CollectionUtil.uniqueResult(list);
		if (dept == null) {
			return null;
		}
		List<Integer> rs = new ArrayList<Integer>();
		rs.add(dept.getId());
		if (dept.getPid() != null && dept.getPid() > 0) {
			List<Integer> ids = getIdPaths(dept.getPid());
			if (ids != null && ids.size() > 0) {
				rs.addAll(ids);
			}
		}
		return rs;
	}

	private String getPathsStr(Integer id) {
		List<Integer> ids = this.getIdPaths(id);

		StringBuilder sb = new StringBuilder();
		for (int i = ids.size() - 1; i >= 0; i--) {
			sb.append(":").append(ids.get((i)));
		}
		return sb.append(":").toString();
	}

	public String flushPath(Integer deptId) {
		String path = getPathsStr(deptId);
		SysDictTreemodel.EntityNode n = SysDictTreemodel.EntityNode.INSTANCE;
		UpdateStatement<SysDictTreemodel> st = StatementBuilder.buildUpdate(n);
		st.restrictions().add(n.id.eq(deptId));
		st.addField(n.path, path);
		this.repo.updateByStatement(st);
		return path;
	}

	private void checkEntity(SysDictTreemodel entity) {
		Assert.notNull(entity.getCode(), "字典编码不能为空");
		if (entity.getPid() == null || entity.getPid() == 0) {
			SysDictTreemodel.EntityNode n = SysDictTreemodel.EntityNode.INSTANCE;
			SelectStatement<SysDictTreemodel> st = StatementBuilder.buildSelect(n);
			st.restrictions().add(n.code.eq(entity.getCode())).add(n.pid.eq(entity.getPid() == null ? 0 : entity.getPid()));
			SysDictTreemodel tmpRoot = CollectionUtil.uniqueResult(this.repo.selectByStatement(st));
			if (tmpRoot != null && !tmpRoot.getId().equals(entity.getId())) {
				throw new RuntimeException("根节点已存在");
			}
		}
	}

	/**
	 * 修改
	 * 
	 * @param entity
	 */
	@Transactional
	public void update(SysDictTreemodel entity) {
		entity.setOpBy(CurrentRequestContext.getOpBy());
		entity.setOpOn(new Date());
		this.checkEntity(entity);

		SysDictTreemodel tmp = this.findById(entity.getPid());
		if (tmp != null && tmp.getPath().contains(":" + entity.getId())) {
			throw new RuntimeException("不能将当前节点或当前节点的下级作为其上级节点");
		}
		String oldIdPath = this.getPathsStr(entity.getId());
		entity.setPath(oldIdPath);
		repo.update(entity);

		String path = this.flushPath(entity.getId());

		this.repo.replacePath(oldIdPath, path);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteById(Integer pk) {
		repo.deleteByPK(pk);
	}

	/**
	 * 通过id获取
	 * 
	 * @param id
	 * @return
	 */
	public SysDictTreemodel findById(Integer pk) {
		return repo.selectByPK(pk);
	}

	/**
	 * 通过非空属性查询
	 * 
	 * @param SysDictTreemodel
	 * @return
	 */
	public List<SysDictTreemodel> findByNotNullProps(SysDictTreemodel entity) {

		SelectStatement<SysDictTreemodel> st = StatementBuilder.buildSelectSelective(entity);
		return repo.selectByStatement(st);
	}

	/**
	 * 通过主键更新非空属性
	 * 
	 * @param SysDictTreemodel
	 * @return
	 */
	public void updateNotNullPropsById(SysDictTreemodel entity) {

		UpdateStatement<SysDictTreemodel> st = StatementBuilder.buildUpdateSelective(entity);
		repo.updateByStatement(st);
	}

	@Override
	public List<SysDictTreemodel> findAllAvaliable(String code) {
		SysDictTreemodel.EntityNode n = SysDictTreemodel.EntityNode.INSTANCE;
		SelectStatement<SysDictTreemodel> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.status.eq(StatusEnum.ENABLE.getValue())).add(n.code.eq(code));
		return this.repo.selectByStatement(st);
	}

	@Override
	public TreeNode<SysDictTreemodel> buildTreeNode(List<SysDictTreemodel> locations) {
		return TreeBuilder.buildRootNode(locations);
	}

	@Override
	public List<SysDictTreemodel> findByQueryParam(SysDictTreemodelQueryParam queryParam) {
		return this.repo.findByQueryParam(queryParam);
	}

	@Override
	public long countByQueryParam(SysDictTreemodelQueryParam queryParam) {
		return this.repo.countByQueryParam(queryParam);
	}

	/**
	 * 建树(非大量数据适用)
	 * 
	 * @author zz
	 *
	 */
	public static class TreeBuilder {

		public static TreeNode<SysDictTreemodel> buildRootNode(List<SysDictTreemodel> deptList) {
			if (deptList == null || deptList.size() < 1)
				return null;

			Integer minId = Integer.MAX_VALUE;
			Map<String, TreeNode<SysDictTreemodel>> tagNodeMap = new HashMap<String, TreeNode<SysDictTreemodel>>();

			for (SysDictTreemodel c : deptList) {
				if (c.getPid() != null) {
					if (c.getPid() == 0 && c.getId() < minId) {
						minId = c.getId();
					}
					if (c.getPid().intValue() > 0 && (c.getPid().intValue() < minId)) {
						minId = c.getPid();
					}

				}

				TreeNode<SysDictTreemodel> cNode = new TreeNode<SysDictTreemodel>();
				cNode.setId(c.getId().toString());
				cNode.setParentId(c.getPid().toString());
				cNode.setNodeVal(c);
				cNode.setText(c.getName());
				tagNodeMap.put(c.getId().toString(), cNode);

			}
			String rootCode = "" + minId;
			TreeNode<SysDictTreemodel> rootNode = tagNodeMap.get(rootCode);
			if (rootNode == null) {
				// 根节点，数据库未存
				TreeNode<SysDictTreemodel> cNode = new TreeNode<SysDictTreemodel>();
				cNode.setId("0");
				cNode.setParentId("-1");
				tagNodeMap.put("0", cNode);
				rootCode = "0";
			}
			for (SysDictTreemodel c : deptList) {
				String pCode = c.getPid() == null ? null : c.getPid().toString();
				if (pCode != null) {
					TreeNode<SysDictTreemodel> pNode = tagNodeMap.get(pCode);
					if (pNode != null) {
						if (pNode.getChildren() == null) {
							pNode.setChildren(new ArrayList<TreeNode<SysDictTreemodel>>());
						}

						// 排序
						int index = 0;
						for (TreeNode<SysDictTreemodel> tmp : pNode.getChildren()) {
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
	public List<SysDictTreemodel> findByIds(List<Integer> ids) {
		SysDictTreemodel.EntityNode n = SysDictTreemodel.EntityNode.INSTANCE;
		SelectStatement<SysDictTreemodel> st = StatementBuilder.buildSelect(n);
		st.restrictions().add(n.id.in(ids));
		return this.repo.selectByStatement(st);
	}

	@Override
	public String getDisplayText(String ids) {
		if(StringUtils.isEmpty(ids)) return "";
		List<Integer> idList = new ArrayList<Integer>();
		String[] idArr = ids.split(",");
		for(String idStr:idArr){
			if(!StringUtils.isEmpty(idStr)){
				idList.add(Integer.parseInt(idStr));
			}
		}
		if(idList.size()<1) return "";
		List<SysDictTreemodel> models = this.findByIds(idList);
		StringBuilder sb = new StringBuilder();
		for(SysDictTreemodel m:models){
			sb.append("、").append(m.getName());
		}
		return sb.substring(1);
	}

}
