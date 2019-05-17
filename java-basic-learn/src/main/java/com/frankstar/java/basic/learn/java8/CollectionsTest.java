package com.frankstar.java.basic.learn.java8;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class CollectionsTest {

	public static void main(String[] args) {
		List<Integer> result = Lists.newArrayList(1,2,3,4,5,6,7,8);
		Collections.shuffle(result);
		System.out.println(result);

	}

}
