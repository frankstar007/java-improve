package com.frankstar.leetcode.DFS;


import com.frankstar.leetcode.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _0509_559N叉树的最大深度 {

	public int maxDepth(Node root) {
		if (root == null) return 0;
		List<Node> children = root.children;
		if (children == null || children.isEmpty()) return 1;
		List<Integer> items = new ArrayList<>();
		for (Node node : children) {
			items.add(maxDepth(node));
		}
		return 1 + Collections.max(items);


//		if (root == null) return 0;
//		List<Node> children = root.children;
//		if (children == null || children.isEmpty()) return 1;
//		//int result = children.stream().map(this::maxDepth).max(Comparator.reverseOrder()).get();
//
//		return 1 + result;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		Node one = new Node(3);
		Node two = new Node(2);
		Node three = new Node(4);

		List<Node> oneC = new ArrayList<>();
		oneC.add(one);
		oneC.add(two);
		oneC.add(three);

		root.children = oneC;

		List<Node> secC = new ArrayList<>();
		Node five = new Node(5);
		Node six = new Node(6);
		secC.add(five);
		secC.add(six);

		one.children= secC;

		_0509_559N叉树的最大深度 s = new _0509_559N叉树的最大深度();
		s.maxDepth(root);
	}

}
