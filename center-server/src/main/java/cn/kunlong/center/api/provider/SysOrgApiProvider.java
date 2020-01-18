package cn.kunlong.center.api.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import app.support.query.PageResult;
import app.support.tree.TreeNode;
import cn.kunlong.center.api.DTFactory;
import cn.kunlong.center.api.dto.queryParam.SysOrgQueryDTO;
import cn.kunlong.center.api.model.SysOrgDTO;
import cn.kunlong.center.api.service.SysOrgApiService;
import cn.kunlong.center.api.transformer.SysOrgTransformer;
import cn.kunlong.center.biz.sys.domain.SysOrg;
import cn.kunlong.center.biz.sys.service.SysOrgService;
import cn.kunlong.center.core.util.BeanMapper;
@Service(version = "${dubbo.service.version}")
public class SysOrgApiProvider implements SysOrgApiService {

	@Autowired
	private SysOrgService service;
	
	private static final SysOrgTransformer T = DTFactory.getInstance(SysOrgTransformer.class);
	
	@Override
	public PageResult<SysOrgDTO> query(SysOrgQueryDTO qpDTO) {
		cn.kunlong.center.biz.sys.domain.SysOrg.QueryParam qp = BeanMapper.getInstance().map(qpDTO, cn.kunlong.center.biz.sys.domain.SysOrg.QueryParam.class);
		List<SysOrg> list = this.service.findByQueryParam(qp);
		long total = this.service.countByQueryParam(qp);
		
		PageResult<SysOrgDTO> page = new PageResult<SysOrgDTO>();
		page.setData(T.produces(list));
		page.setTotal(total);
		return page;
	}

	@Override
	public Integer save(SysOrgDTO entityDTO) {
		SysOrg entity = T.consume(entityDTO);
		if(entity.getId() == null) {
			this.service.save(entity);
		} else {
			SysOrg tmp = this.service.findById(entity.getId());
			BeanMapper.getInstance().map(entity, tmp);
			this.service.update(tmp);
		}
		return entity.getId();
	}

	@Override
	public SysOrgDTO findById(Integer id) {
		SysOrg tmp = this.service.findById(id);
		return T.produce(tmp);
	}

	@Override
	public void delete(Integer id) {
		this.service.deleteById(id);
	}

	@Override
	public List<SysOrgDTO> findByIds(List<Integer> ids) {
		List<SysOrg> suList = this.service.findByIds(ids);
		return T.produces(suList);
	}

	@Override
	public TreeNode<SysOrgDTO> tree(Integer corpId) {
		cn.kunlong.center.core.support.tree.TreeNode<SysOrg> root = this.service.getRootNode(corpId);
		
		return transTree(root);
	}
	
	private TreeNode<SysOrgDTO> transTree(cn.kunlong.center.core.support.tree.TreeNode<SysOrg> node){
		TreeNode<SysOrgDTO> r = new TreeNode<SysOrgDTO>();
		r.setId(node.getId());
		r.setNodeAttr(node.getNodeAttr());
		r.setNodeVal(DTFactory.getInstance(SysOrgTransformer.class).produce(node.getNodeVal()));
		r.setParentId(node.getParentId());
		r.setText(node.getText());
		
		if(node.getChildren() != null ) {
			r.setChildren(new ArrayList<TreeNode<SysOrgDTO>>());
			
			for(cn.kunlong.center.core.support.tree.TreeNode<SysOrg> cNode:node.getChildren()) {
				r.getChildren().add(this.transTree(cNode));
			}
		}
		return r;
	}
	
}
