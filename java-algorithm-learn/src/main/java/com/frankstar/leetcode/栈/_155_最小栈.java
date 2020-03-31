package com.frankstar.leetcode.栈;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/2/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/min-stack/
 */
public class _155_最小栈 {

	private Stack<Integer> data;


	private Stack<Integer> min;

	/** initialize your data structure here. */
	public _155_最小栈() {
		this.data = new Stack<>();
		this.min = new Stack<>();
	}

	public void push(int x) {
		//原栈的操作正常
		data.push(x);

		if (min.isEmpty() || x<= min.peek()) {
			min.push(x);
		}

	}

	public void pop() {
		if (min.isEmpty()) return;
		if (data.isEmpty()) return;
		if (min.peek().equals(data.peek())) {
			min.pop();
		}
		data.pop();


	}

	public int top() {
		return  data.peek();
	}

	public int getMin() {
		return  min.peek();
	}

	public static void main(String[] args) {
		_155_最小栈 minStack = new _155_最小栈();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		minStack.getMin();
		minStack.pop();
		minStack.top();
		minStack.getMin();

	}
}
