package com.frankstar.first;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Author    :  frankstar
 * AddTime   :  2018/11/23
 * EMail     :  yehongxing@meituan.com
 * Project   :  chapter1
 * desc 	 : 在一个二维数组中（每个一维数组的长度相同），
 * 			每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 			请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class HashMapStudy {

	public static void main(String[] args) {
		List<String> strins = Stream.of("C", "A", "B").sorted().collect(Collectors.toList());

		int [][] array = new int[3][4];
		System.out.println(array.length);
		System.out.println(array[0].length);

	}

}
