package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/subtree-of-another-tree/
 */
public class _0507_572另一个树的子树 {


	public boolean isSubtree(TreeNode s, TreeNode t) {
		// t 为 null 一定都是 true
		if (t == null) return true;
		// 这里 t 一定不为 null, 只要 s 为 null，肯定是 false
		if (s == null) return false;
		return isSubtree(s.left, t) || isSubtree(s.right, t) || isSameTree(s,t);
	}

	/**
	 * 判断两棵树是否相同
	 */
	public boolean isSameTree(TreeNode s, TreeNode t){
		if (s == null && t == null) return true;
		if (s == null || t == null) return false;
		if (s.val != t.val) return false;
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}




	public static void main(String[] args) {
		_0507_572另一个树的子树 c = new _0507_572另一个树的子树();
		TreeNode s = new TreeNode(3);
		s.left = new TreeNode(4);
		s.right = new TreeNode(5);
		s.left.left  = new TreeNode(1);
		s.left.right = new TreeNode(2);
		s.left.left.left = new TreeNode(0);


		TreeNode t = new TreeNode(3);
		t.left = new TreeNode(1);
		t.right = new TreeNode(2);
		c.isSubtree(s, t);
	}


}
