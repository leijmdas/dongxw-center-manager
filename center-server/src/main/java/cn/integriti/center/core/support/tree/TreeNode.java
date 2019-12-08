package cn.integriti.center.core.support.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TreeNode<T> implements Cloneable {

	private String id;
	private String parentId;
	private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();
	private T nodeVal;
	private Object nodeAttr;
	
	private String text;

	public T getNodeVal() {
		return nodeVal;
	}

	public void setNodeVal(T nodeVal) {
		this.nodeVal = nodeVal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<TreeNode<T>> getChildren() {
		return children;
	}

	public void setChildren(List<TreeNode<T>> children) {
		this.children = children;
	}

	public Object getNodeAttr() {
		return nodeAttr;
	}

	public void setNodeAttr(Object nodeAttr) {
		this.nodeAttr = nodeAttr;
	}

	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean getLeaf(){
		return this.children == null||this.children.size()<1?true:false;
	}
	/**
	 * 克隆（浅拷贝）
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public TreeNode<T> cloneSelf() {
		try {
			TreeNode<T> node = (TreeNode<T>) super.clone();
			if (node.children != null) {
				List<TreeNode<T>> childrens = new ArrayList<TreeNode<T>>();
				for (TreeNode<T> n : this.children) {
					childrens.add(n.cloneSelf());
				}
				node.setChildren(childrens);
			}
			return node;
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("clone treenode exception:" + e.getMessage(), e);
		}
	}

	public static interface INode<T> {
		TreeNode<T> conver2Node(T t);
	}

	/**
	 * 简单方式返回一个树型结构(一般用于数据量较小的情况下)
	 * 
	 * @param root
	 * @param nodes
	 * @return
	 */
	public static <T> TreeNode<T> buildTree(TreeNode<T> rootNode, List<T> data, TreeNode.INode<T> node) {
		TreeMap<String, TreeNode<T>> allNodeMap = new TreeMap<String, TreeNode<T>>();
		for (T t : data) {
			TreeNode<T> tNode = node.conver2Node(t);
			allNodeMap.put(tNode.getId(), tNode);
		}
		allNodeMap.put(rootNode.getId(), rootNode);
		buildTreeNode(allNodeMap);
		return rootNode;
	}

	private static <T> void buildTreeNode(Map<String, TreeNode<T>> nodeMap) {
		for (Map.Entry<String, TreeNode<T>> entry : nodeMap.entrySet()) {
			TreeNode<T> pNode = nodeMap.get(entry.getValue().getParentId());
			if (pNode != null && !pNode.getId().equals(entry.getKey())) {
				pNode.getChildren().add(entry.getValue());
			}

		}
	}
}
