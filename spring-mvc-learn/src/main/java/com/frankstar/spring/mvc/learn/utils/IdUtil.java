package com.frankstar.spring.mvc.learn.utils;

import java.util.UUID;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : id随机生成器
 */
public class IdUtil {

	public static int getId() {
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();

		//去掉短横线
		id = id.replace("-", "");
		int idNum = id.hashCode();
		idNum = idNum < 0 ? -idNum : idNum;

		return idNum;
	}


	public static String genId() {
		return UUID.randomUUID().toString();
	}


}

