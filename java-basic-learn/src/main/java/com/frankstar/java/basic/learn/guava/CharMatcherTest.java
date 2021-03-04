package com.frankstar.java.basic.learn.guava;

import com.google.common.base.CharMatcher;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class CharMatcherTest {


	public static void main(String[] args) {
		String skuName = "元正蟹味菇（鲜）200";
		skuName = CharMatcher.anyOf("（").replaceFrom(skuName, "(");
		skuName = CharMatcher.anyOf("）").replaceFrom(skuName, ")");
		System.out.println(skuName);

	}

}
