package com.frankstar.leetcode.栈;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/baseball-game/
 */
public class _682_棒球比赛 {


	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();

		for (int i=0; i<ops.length; i++) {
			if (notASym(ops[i])) {
				Integer num = Integer.valueOf(ops[i]);
				stack.push(num);
			}


			if(ops[i].equals("C")) {
				stack.pop();
			}
			if (ops[i].equals("D")) {
				Integer num = stack.peek();
				stack.push(num * 2);
			}

			if (ops[i].equals("+")) {
				int num1 = stack.pop();
				int num2 = stack.pop();
				int tmp = num1 + num2;
				stack.push(num2);
				stack.push(num1);
				stack.push(tmp);
			}

		}
		int result = 0;
		while(!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;

	}

	private boolean notASym(String op) {
		if(op.equals("C")) return false;
		if (op.equals("D")) return false;
		if (op.equals("+")) return false;
		return true;
	}

}
