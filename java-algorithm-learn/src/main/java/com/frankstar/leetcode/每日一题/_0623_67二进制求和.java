package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/add-binary/
 */
public class _0623_67二进制求和 {

	public String addBinary(String a, String b) {

		if (b.length() == 0) return a;
		if (a.length() == 0) return b;

		StringBuilder sb = new StringBuilder();
		int aEnd = a.length() -1;
		int bEnd = b.length() -1;
		boolean flag = false;
		while (aEnd >= 0 && bEnd >= 0) {
			int result = (a.charAt(aEnd) - '0') + (b.charAt(bEnd) - '0');
			if (flag) {
				flag = result + 1 >= 2;
				result = (result + 1) % 2;
			}else {
				flag = result >= 2;
				result = result % 2;
			}
			sb.append(result);
			aEnd--;
			bEnd--;
		}
		while (aEnd >= 0) {
			int result = (a.charAt(aEnd) - '0');
			if (flag) {
				flag = result + 1 >= 2;
				result = (result + 1) % 2;
			} else {
				flag = result >= 2;
			}
			sb.append(result);
			aEnd--;
		}

		while (bEnd >= 0) {
			int result = (b.charAt(bEnd) - '0');
			if (flag) {
				flag = result + 1 >= 2;
				result = (result + 1) % 2;
			} else {
				flag = result >= 2;
			}
			sb.append(result);
			bEnd--;
		}

		if(flag) {
			sb.append(1);
		}

		return sb.reverse().toString();


	}

	public static void main(String[] args) {
		String a = "11";
		String b = "1";
		_0623_67二进制求和 s = new _0623_67二进制求和();
		String result = s.addBinary(a, b);
		System.out.println(result);
	}

}
