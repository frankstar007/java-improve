package com.frankstar.java.basic.learn.poseidon;

import com.frankstar.java.basic.learn.json.User;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/7/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class StringRer {

	public static void main(String[] args) {
		String desc = "这个不错！仅售138元，我是一个联票1";
		Double originMinPrice = 138.0;

		desc = desc.replace(String.valueOf(originMinPrice),  String.valueOf(1));

		Double A= 61.4;
		Integer B = 9;
		Double Ba = Double.valueOf(B);
		Double c = A- (double)B;
		System.out.println(c);



		User user = new User();
		user.setLat(0.0);
		System.out.println(user.getLat() == 0);

	}

}
