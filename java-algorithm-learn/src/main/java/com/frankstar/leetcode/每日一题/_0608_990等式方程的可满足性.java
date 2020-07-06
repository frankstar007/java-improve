package com.frankstar.leetcode.每日一题;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 */
public class _0608_990等式方程的可满足性 {

	public boolean equationsPossible(String[] equations) {
		Map<Character,Integer> map = new LinkedHashMap<>();
		int size = equations.length;
		if (size == 0) return true;
		for (int i=0;i<size; i++) {
			String item = equations[i];
			char head = item.charAt(0);
			char tail = item.charAt(item.length() - 1);
			String eq = item.substring(1, item.length()-1);
			if (eq.equals("==")) {
				map.putIfAbsent(head, 1);
				map.putIfAbsent(tail, map.get(head));
			} else {
				int last = 0;
				if (map.size() != 0) {
					last = map.values().stream()
						.mapToInt(v-> v).max().getAsInt();
				}
				map.putIfAbsent(head, last);
				map.putIfAbsent(tail, last+1);
			}
			if (map.get(head) != null && map.get(tail) != null) {
				int headNum = map.get(head);
				int tailNum = map.get(tail);
				if (eq.equals("==")) {
					if (headNum != tailNum) return false;
				} else {
					if (headNum == tailNum) return false;
				}

			}
		}
		return true;
	}


	public static void main(String[] args) {
		_0608_990等式方程的可满足性 s = new _0608_990等式方程的可满足性();
		String[] eq = new String[]{"c==c","f!=a","f==b","b==c"};
		boolean result = s.equationsPossible(eq);
		System.out.println(result);
	}

}
