package com.frankstar.leetcode.栈;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/2/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/implement-stack-using-queues/
 */
public class _225_用队列实现栈 {

	private Queue<Integer> queue;

	/** Initialize your data structure here. */
	public _225_用队列实现栈() {
		this.queue = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		int size = queue.size();
		while (size > 1) {
			queue.add(queue.remove());
			size--;
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue.remove();
	}

	/** Get the top element. */
	public int top() {
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}

}
