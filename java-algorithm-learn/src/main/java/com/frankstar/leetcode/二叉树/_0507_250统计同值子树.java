package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/count-univalue-subtrees/
 */
public class _0507_250统计同值子树 {

	private int count;


	public int countUnivalSubtrees(TreeNode root) {
		isUni(root, count);
		return count;
	}

	public boolean isUni(TreeNode node, int count) {
		if (node == null) return true;
		boolean left = isUni(node.left, count);
		boolean right = isUni(node.right, count);
		if (node.left != null && node.left.val != node.val || node.right != null && node.right.val != node.val) {
			return false;
		}
		if (left && right) {
			count += 1;
		}
		return true;
	}



	private void   countTrees(TreeNode root, int count) {
		if (root.right == null && root.left == null) {
			count = count + 1;
			return;
		}
		if (root.right == null) {
			if (root.left.val == root.val) {
				count = count + 1;
			}
			countTrees(root.left, count);
			return;
		}

		if (root.left == null) {
			if (root.right.val == root.val) {
				count = count + 1;
			}
			countTrees(root.right, count);
			return;
		}

		if(root.val == root.right.val && root.val == root.left.val) {
			count += 1;
		}
		countTrees(root.left, count);
		countTrees(root.right, count);

	}


//	boolean is_uni(TreeNode node) {
//
//		//base case - if the node has no children this is a univalue subtree
//		if (node.left == null && node.right == null) {
//
//			// found a univalue subtree - increment
//			count++;
//			return true;
//		}
//
//		boolean is_unival = true;
//
//		// check if all of the node's children are univalue subtrees and if they have the same value
//		// also recursively call is_uni for children
//		if (node.left != null) {
//			is_unival = is_uni(node.left) && is_unival && node.left.val == node.val;
//		}
//
//		if (node.right != null) {
//			is_unival = is_uni(node.right) && is_unival && node.right.val == node.val;
//		}
//
//		// return if a univalue tree exists here and increment if it does
//		if (!is_unival) return false;
//		count++;
//		return true;
//	}
//
//	public int countUnivalSubtrees(TreeNode root) {
//		if (root == null) return 0;
//		is_uni(root);
//		return count;
//	}




	public static void main(String[] args) {
		_0507_250统计同值子树 s = new _0507_250统计同值子树();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);

		//root.right.left = new TreeNode(5);
		root.right.right= new TreeNode(5);
		int result = s.countUnivalSubtrees(root);
		System.out.println(result);
	}
}
