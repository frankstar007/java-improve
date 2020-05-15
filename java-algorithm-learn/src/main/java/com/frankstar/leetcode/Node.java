package com.frankstar.leetcode;

import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class Node {

	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}
