package com.frankstar.leetcode.二叉树;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/20/
 */
public class 二叉树的序列化与反序列化 {

	// Encodes a tree to a single string.
	public String sserialize(TreeNode root) {
		StringBuilder result = new StringBuilder();
		if (root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i< size; i++) {
				TreeNode tmp = queue.peek();
				result.append(tmp.val);
				queue.poll();

				if (tmp.left != null) {
					queue.add(tmp.left);
				} else {
					result.append("null");
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				} else {
					result.append("null");
				}
			}

		}
		return result.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] data_array = data.split(",");
		List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		return rdeserialize(data_list);
	}

	private TreeNode rdeserialize(List<String> l) {
		// Recursive deserialization.
		if (l.get(0).equals("null")) {
			l.remove(0);
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		l.remove(0);
		root.left = rdeserialize(l);
		root.right = rdeserialize(l);

		return root;
	}


	public String rserialize(TreeNode root, String str) {
			// Recursive serialization.
			if (root == null) {
				str += "null,";
			} else {
				str += String.valueOf(root.val) + ",";
				str = rserialize(root.left, str);
				str = rserialize(root.right, str);
			}
			return str;
		}

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			return rserialize(root, "");
		}




}
