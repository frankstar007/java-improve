package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class _0510_236二叉树的最近公共祖先 {

	//存储每个节点的父节点集合
	private Map<Integer, List<Integer>> parent = new HashMap<>();

	public TreeNode rec_lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null || root == p || root == q) return root;
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if(left == null) return right;
		if(right == null) return left;
		return root;
	}


	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return root;
		List<Integer> rootList = new ArrayList<>();
		rootList.add(root.val);
		parent.put(root.val, rootList);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size=  queue.size();
			for (int i=0; i<size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.left != null) {
					List<Integer> nodes = new ArrayList<>(parent.get(tmp.val));
					queue.add(tmp.left);
					nodes.add(tmp.left.val);
					parent.put(tmp.left.val, nodes);
				}
				if (tmp.right != null) {
					List<Integer> nodes = new ArrayList<>(parent.get(tmp.val));
					queue.add(tmp.right);
					nodes.add(tmp.right.val);
					parent.put(tmp.right.val, nodes);
				}

			}
		}
		//PrintObject.printO(parent);

		List<Integer> pList = parent.get(p.val);
		List<Integer> qList = parent.get(q.val);
		if (pList.size() == 0 || qList.size() == 0) return root;
		int i= 0, j=0;
		while (i < pList.size() && j < qList.size() && pList.get(i).equals( qList.get(i))) {
				i++;
				j++;
		}
		if (i == pList.size()) {
			return new TreeNode(pList.get(i-1));
		}else if (j == pList.size()) {
			return new TreeNode(pList.get(j-1));
		} else {
			return new TreeNode(pList.get(i-1));
		}


	}


	public static void main(String[] args) {
		TreeNode root = TreeNode.getInstance();
		_0510_236二叉树的最近公共祖先 s = new _0510_236二叉树的最近公共祖先();
		TreeNode result = s.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
		PrintObject.printO(result.val);
	}
}
