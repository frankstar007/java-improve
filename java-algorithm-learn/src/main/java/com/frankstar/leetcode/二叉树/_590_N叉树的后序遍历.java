package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.MNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {


	public List<Integer> postorder(MNode root) {
		List<Integer> result = new LinkedList<>();
		if (root == null) return result;

		Stack<MNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			MNode cur = stack.pop();
			result.add(cur.val);
			if (cur.children != null) {
				for (MNode mNode : cur.children) {
					stack.push(mNode);
				}

			}

		}
		Collections.reverse(result);

		return result;
	}

}
