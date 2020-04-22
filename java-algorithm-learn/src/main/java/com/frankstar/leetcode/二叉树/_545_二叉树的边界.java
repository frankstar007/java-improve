package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/boundary-of-binary-tree/
 */
public class _545_二叉树的边界 {

	/**
	 * 给定一棵二叉树，以逆时针顺序从根开始返回其边界。边界按顺序包括左边界、叶子结点和右边界而不包括重复的结点。 (结点的值可能重复)

	 左边界的定义是从根到最左侧结点的路径。右边界的定义是从根到最右侧结点的路径。若根没有左子树或右子树，则根自身就是左边界或右边界。注意该定义只对输入的二叉树有效，而对子树无效。

	 最左侧结点的定义是：在左子树存在时总是优先访问，如果不存在左子树则访问右子树。重复以上操作，首先抵达的结点就是最左侧结点。

	 最右侧结点的定义方式相同，只是将左替换成右。

	 * @param root
	 * @return
	 */
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return result;
		}
		//先求左边界
		leftBoarder(root, result);
		PrintObject.printO(result);
		//求叶子节点
		leafNodes(root, result);
		PrintObject.printO(result);
		//求右边界
		rightBoarder(root, result);
		result.remove(result.size() - 1);


		return result;


	}

	private void rightBoarder(TreeNode root, List<Integer> result) {
		if (root == null) return;
		TreeNode tmp = root.right;
		List<Integer> items = new ArrayList<>();
		while (tmp != null) {
			if (!isLeafNode(tmp)) {
				items.add(tmp.val);
			}
			if (tmp.right != null) {
				tmp = tmp.right;
			} else {
				tmp = tmp.left;
			}
		}

		Collections.reverse(items);
		result.addAll(items);
	}


	private void leftBoarder(TreeNode root, List<Integer> result) {
		if (root == null) return;
		if (!isLeafNode(root)) {
			result.add(root.val);
		}
		TreeNode tmp = root.left;
		while (tmp != null) {
			if (!isLeafNode(tmp)) {
				result.add(tmp.val);
			}
			if (tmp.left != null) {
				tmp = tmp.left;
			} else {
				tmp = tmp.right;
			}
		}

	}

	private boolean isLeafNode(TreeNode tmp) {
		return tmp.right == null && tmp.left == null;
	}


	public boolean isLeaf(TreeNode t) {
		return t.left == null && t.right == null;
	}

	public void addLeaves(List<Integer> res, TreeNode root) {
		if (isLeaf(root)) {
			res.add(root.val);
		} else {
			if (root.left != null) {
				addLeaves(res, root.left);
			}
			if (root.right != null) {
				addLeaves(res, root.right);
			}
		}
	}

	private void leafNodes(TreeNode root, List<Integer> result) {
		if (root == null) return;
		if (isLeafNode(root)) {
			result.add(root.val);
		} else {
			leafNodes(root.left, result);
			leafNodes(root.right, result);
		}
	}

	public List<Integer> ans_boundaryOfBinaryTree(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		if (!isLeaf(root)) {
			res.add(root.val);
		}
		TreeNode t = root.left;
		while (t != null) {
			if (!isLeaf(t)) {
				res.add(t.val);
			}
			if (t.left != null) {
				t = t.left;
			} else {
				t = t.right;
			}

		}
		addLeaves(res, root);
		Stack<Integer> s = new Stack<>();
		t = root.right;
		while (t != null) {
			if (!isLeaf(t)) {
				s.push(t.val);
			}
			if (t.right != null) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		while (!s.empty()) {
			res.add(s.pop());
		}
		return res;
	}





	public static void main(String[] args) {
		_545_二叉树的边界  s= new _545_二叉树的边界();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);

		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);


		TreeNode nRoot = new TreeNode(1);
		nRoot.right = new TreeNode(2);
		nRoot.right.left = new TreeNode(3);
		nRoot.right.right = new TreeNode(4);


		TreeNode treeNode = new TreeNode(1);


		List<Integer> result = s.boundaryOfBinaryTree(nRoot);
		PrintObject.printO(result);
	}
}
