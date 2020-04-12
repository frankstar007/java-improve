package com.frankstar.leetcode.每日一题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class _22_括号生成 {

	/**
	 * 深度遍历 做减法
	 * @param n
	 * @return
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) return res;

		//执行深度遍历 探索可能的结果
		dfs(res, n,n,"");
		return res;


	}

	/**
	 *
	 * @param res 结果集
	 * @param left 左括号还有几个可用
	 * @param right 右括号还有几个可用
	 * @param str 当前递归得到的结果 str
	 */
	private void dfs(List<String> res, int left, int right, String str) {
		//递归终止时 将str放入结果集
		if (left == 0 && right == 0) {
			res.add(str);
			return;
		}
		//剪枝 如果左括号的个数大于右括号 才进行剪枝
		if (left > right) return;

		if(left > 0) {
			dfs(res, left-1, right, str + "(");
		}

		if (right > 0) {
			dfs(res, left, right-1, str + ")");
		}
	}


	/**
	 * 深度遍历 做加法
	 * @param n
	 * @return
	 */
	public List<String> dfsGenerateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n == 0) return res;

		//执行深度遍历 探索可能的结果
		dfsAdd(res, 0,0 ,n,"");
		return res;


	}


	/**
	 *
	 * @param res 结果集
	 * @param left 已用左括号
	 * @param right 已用右括号
	 * @param n 总共
	 * @param str
	 */
	private void dfsAdd(List<String> res, int left, int right, int n, String str) {
		if(left == n && right == n) {
			res.add(str);
			return;
		}
		//剪枝
		if (left < right) return;

		if (left < n) {
			dfs(res, left + 1, right, str + "(");
		}

		if (right < n) {
			dfs(res, left, right+1, str + ")");
		}

	}

	class Node {
		String res;

		int left;

		int right;

		Node(String res, int left, int right) {
			this.left = left;
			this.res = res;
			this.right = right;
		}
	}


	public List<String> bfsGenerateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		if (n== 0) return res;
		Deque<Node> nodeDeque = new ArrayDeque<>();

		//放入第一个
		nodeDeque.addLast(new Node("", n, n));
		while (!nodeDeque.isEmpty()) {
			Node cur = nodeDeque.removeLast();
			if (cur.right == 0 && cur.left == 0) {
				res.add(cur.res);
			}
			if (cur.left > 0) {
				nodeDeque.addLast(new Node(cur.res + "(", cur.left-1, cur.right));
			}

			if (cur.right > 0 && cur.left < cur.right) {
				nodeDeque.addLast(new Node(cur.res + ")", cur.left, cur.right-1));
			}
		}

		return res;
	}

	/**
	 * 深度优先队列
	 * @param n
	 * @return
	 */
	public List<String> bfsQueue(int n) {
		List<String> res = new ArrayList<>();
		if (n== 0) return res;
		Queue<Node> queue = new LinkedList<>();

		//放入第一个
		queue.add(new Node("", n, n));
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			if (cur.right == 0 && cur.left == 0) {
				res.add(cur.res);
			}
			if (cur.left > 0) {
				queue.add(new Node(cur.res + "(", cur.left-1, cur.right));
			}

			if (cur.right > 0 && cur.left < cur.right) {
				queue.add(new Node(cur.res + ")", cur.left, cur.right-1));
			}
		}

		return res;
	}


	/**
	 * 动态规划
	 * dp[i] = "(" + dp[j] + ")" + dp[i- j - 1] , j = 0, 1, ..., i - 1
	 * @param n
	 * @return
	 */
	public List<String> dp_generateParenthesis(int n) {
		if (n == 0) return new ArrayList<>();
		//dp 数组
		List<List<String>> dp = new ArrayList<>();

		//初始化 dp0
		List<String> dp0 = new ArrayList<>();
		dp0.add("");
		dp.add(dp0);

		for (int i=1; i<n; i++) {
			List<String> cur = new ArrayList<>();
			for (int j=0; j<i; j++) {
				List<String> str1 = dp.get(j);
				List<String> str2 = dp.get(i-j-1);

				for (String st1 : str1) {
					for (String st2 : str2) {
						cur.add("(" + st1 + ")" + st2);
					}
				}
			}
			dp.add(cur);
		}

		return dp.get(n);

	}


}
