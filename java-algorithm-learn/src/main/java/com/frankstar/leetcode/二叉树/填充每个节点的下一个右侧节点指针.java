package com.frankstar.leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/17/
 */
public class 填充每个节点的下一个右侧节点指针 {

	/**
	 * 迭代法、
	 * 因为是完美二叉树，如果有左子树，一定有右子树。我们将结点的左子树和右子树相连。
	 如果结点next不为空，那么将结点右子树指向结点next的左子树。
	 同时递归处理左子树和右子树。
	 * @param node
	 */
	public void connect(Node node) {
		if (node == null) return;
		if (node.left != null) {
			node.left.next = node.right;
			if (node.next != null) {
				node.right.next = node.next.left;
			}
		}
		connect(node.left);
		connect(node.right);
	}


	public Node connectNode(Node root) {
		if (root == null) return root;
		Node newR = root;
		if (newR.left != null) {
			newR.left.next = newR.right;
			if (newR.next != null) {
				newR.right.next = newR.next.left;
			}
		}
		newR.left = connectNode(newR.left);
		newR.right = connectNode(newR.right);

		return root;
	}


	/**
	 * 层序遍历法
	 * 利用层序遍历，每一层都将指针指向他的下一个结点，
	 *这里用size标记每一层是否遍历完毕。
	 * @param node
	 */
	public void layerConnect(Node node) {
		if(node == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i=0; i< size; i++) {
				Node tmp = q.peek();
				q.poll();
				if (i < size - 1) {
					tmp.next = q.peek();
				}
				if (tmp.left != null) q.add(tmp.left);
				if (tmp.right != null) q.add(tmp.right);

			}
		}

	}

	public Node layerConnected(Node root) {
		if (root == null) return root;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i< size; i++) {
				Node tmp = queue.peek();
				queue.poll();
				if (i < size - 1) {
					tmp.next = queue.peek();
				}
				if (tmp.left != null) queue.add(tmp.left);
				if (tmp.right != null) queue.add(tmp.right);

			}
		}
		return root;
	}

	/**
	 * 最巧妙的方法 利用层指针和深度指针
	 * @param node
	 */
	public void smartConnect(Node node) {
		if (node == null) return;
		Node cur = null, start = node;
		while (start.left != null) {
			cur = start;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}
				//层指针
				cur = cur.next;
			}
			//深度遍历指针
			start = start.left;
		}
	}

}
