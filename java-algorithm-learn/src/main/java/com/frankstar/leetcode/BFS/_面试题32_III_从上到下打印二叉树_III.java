package com.frankstar.leetcode.BFS;

import com.frankstar.leetcode.二叉树.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _面试题32_III_从上到下打印二叉树_III {

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<List<Integer>> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			List<Integer> childrens = new ArrayList<>();
			int size = queue.size();
			boolean odd = true;
			for (int i=0; i<size; i++) {
				TreeNode tmp = queue.poll();
				childrens.add(tmp.val);

				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
			}
			result.add(childrens);
		}
		// 在处理一下
		for(int i= 0; i< result.size(); i++) {
			if (i % 2 !=0) {
				reverse(result.get(i));
			}
		}

		return result;

	}


	public List<List<Integer>> deQueue(TreeNode root) {
		Deque<TreeNode> deque = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<>();
		if(root != null) deque.add(root);
		while(!deque.isEmpty()) {
			// 打印奇数层
			List<Integer> tmp = new ArrayList<>();
			for(int i = deque.size(); i > 0; i--) {
				// 从左向右打印
				TreeNode node = deque.removeFirst();
				tmp.add(node.val);
				// 先左后右加入下层节点
				if(node.left != null) deque.addLast(node.left);
				if(node.right != null) deque.addLast(node.right);
			}
			res.add(tmp);
			if(deque.isEmpty()) break;
			// 打印偶数层
			tmp = new ArrayList<>();
			for(int i = deque.size(); i > 0; i--) {
				// 从右向左打印
				TreeNode node = deque.removeLast();
				tmp.add(node.val);
				// 先右后左加入下层节点
				if(node.right != null) deque.addFirst(node.right);
				if(node.left != null) deque.addFirst(node.left);
			}
			res.add(tmp);
		}
		return res;
	}



	private void reverse(List<Integer> list) {
		int mid = list.size() / 2;
		int size = list.size();
		for (int i=0; i< mid; i++) {
			int tmp = list.get(i);
			list.set(i, list.get(size - 1- i));
			list.set(size -1-i, tmp);
		}

	}


	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		_面试题32_III_从上到下打印二叉树_III s = new _面试题32_III_从上到下打印二叉树_III();
		s.reverse(list);
		System.out.println(list);
	}


}
