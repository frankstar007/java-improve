package com.frankstar.java.basic.learn.list;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ListTest {

	public static void main(String[] args) {
		List<Integer> test = Lists.newArrayList(15255);
		List<Integer> sale = Lists.newArrayList(0);
		System.out.println(test.containsAll(sale));


		List<Integer> A = Lists.newArrayList(1,2,3,4,5);


		List<List<Integer>> items = Lists.partition(A, 2);
		System.out.println(new Gson().toJson(A));

		List<Integer> B = Lists.newArrayList(2,3,5);

		A.removeAll(B);
		System.out.println(A);

		List<String> stringList = Lists.newArrayList("yehongxing");

		String[] m = stringList.toArray(new String[stringList.size()]);

		System.out.println(new Gson().toJson(m));
	}
}
