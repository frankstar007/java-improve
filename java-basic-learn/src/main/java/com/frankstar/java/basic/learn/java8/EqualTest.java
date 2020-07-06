package com.frankstar.java.basic.learn.java8;

import java.util.Objects;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class EqualTest {

	public static void main(String[] args) {
		Short one = 1;
		Integer two = 1;



		System.out.println(Objects.equals(Integer.valueOf(one), two));
	}

}
