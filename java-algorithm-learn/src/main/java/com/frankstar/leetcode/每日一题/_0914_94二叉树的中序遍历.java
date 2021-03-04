package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.二叉树.TreeNode;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 二叉树的中序遍历
 */
public class _0914_94二叉树的中序遍历 {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;
		inorder(root, result);
		return result;
	}

	private void inorder(TreeNode node, List<Integer> result) {
		if (node.left != null) inorder(node.left, result);
		result.add(node.val);
		if (node.right != null) inorder(node.right, result);
	}

	/**
	 * 中序迭代
	 * @param root
	 * @return
	 */
	private List<Integer> diedai_mid(TreeNode root) {
		List<Integer> result = Lists.newArrayList();
		if (root == null) return result;
		Stack<TreeNode> s = new Stack<>();
		TreeNode p = root;
		//如果栈不为空
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p);
				//访问左节点
				p = p.left;
			}
			p = s.pop();
			result.add(p.val);
			p = p.right;
		}
		return result;
	}


	private List<Integer> diedai_pre(TreeNode root) {
		List<Integer> result = Lists.newArrayList();
		if (root == null) return result;
		Stack<TreeNode> s = new Stack<>();
		TreeNode p = root;
		//如果栈不为空
		while (p != null || !s.isEmpty()) {
			while (p != null) {
				s.push(p.right);
				result.add(p.val);
				p = p.left;
			}
			p = s.pop();
		}
		return result;
	}

}
