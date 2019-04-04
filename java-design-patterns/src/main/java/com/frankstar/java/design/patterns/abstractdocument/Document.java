package com.frankstar.java.design.patterns.abstractdocument;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface Document {

	/**
	 * 添加属性
	 * @param key
	 * @param value
	 */
	void put(String key, Object value);


	/**
	 * 获取属性
	 * @param key
	 * @return
	 */
	Object get(String key);


	/**
	 * 获取子节点的文件流
	 * @param key
	 * @param constructor
	 * @param <T>
	 * @return
	 */
	<T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor);
}
