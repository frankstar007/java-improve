package com.frankstar.leetcode.队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

 */
public class _面试题59_II_队列的最大值 {


	static class MaxQueue {

		private Queue<Integer> datas;

		private Deque<Integer> maxData;



		public MaxQueue() {
			datas = new LinkedList<>();
			maxData = new ArrayDeque<>();

		}

		//最大的值在最前面
		public int max_value() {
			return maxData.isEmpty() ? -1 : maxData.peek();
		}

		public void push_back(int value) {

			datas.add(value);
			while (!maxData.isEmpty() && maxData.peekLast() < value) {
					maxData.pollLast();
				}
				maxData.addLast(value);
			}



		public int pop_front() {
			if (datas.isEmpty()) return -1;
			int data = datas.poll();
			if (!maxData.isEmpty() && data == maxData.peek()) {
				maxData.poll();
			}
			return data;
		}
	}
	public static void sout(Object o) {
		System.out.print(o);
	}

	public static void main(String[] args) {
		MaxQueue maxQueue = new MaxQueue();
//		sout(maxQueue.pop_front());
//		sout(maxQueue.pop_front());
//		sout(maxQueue.pop_front());
//		sout(maxQueue.pop_front());
//		sout(maxQueue.pop_front());
//		maxQueue.push_back(15);
//		sout(maxQueue.max_value());
//		maxQueue.push_back(9);
//		sout(maxQueue.max_value());
		maxQueue.push_back(1);
		maxQueue.push_back(2);
		sout(maxQueue.max_value());
		sout(maxQueue.pop_front());
		sout(maxQueue.max_value());



	}

}
