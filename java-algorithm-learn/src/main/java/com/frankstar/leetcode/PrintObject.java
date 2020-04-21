package com.frankstar.leetcode;

import com.google.gson.Gson;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class PrintObject {


	public static void printO(Object o) {
		Gson gson = new Gson();
		System.out.println(gson.toJson(o));
	}

}
