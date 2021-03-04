package com.frankstar.java.basic.learn.json;

import com.alibaba.fastjson.JSON;
import com.frankstar.java.basic.learn.json.filter.SimplePropertyPreFilter;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/7/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class FastJson {

	private static Pattern SET_METHOD_FILTER = Pattern.compile("set[A-Z].*");
	private static Pattern ITERATOR_FILTER = Pattern.compile(".*Iterator");
	private static Pattern SIZE_PROPERTY_FILTER = Pattern.compile(".*Size");

	protected static Set<Pattern> EXLUDE_PATTERNS = Sets
		.newHashSet(SET_METHOD_FILTER, ITERATOR_FILTER,
			SIZE_PROPERTY_FILTER);


	public static void main(String[] args) {
		User user = new User();
		SimplePropertyPreFilter filter = new SimplePropertyPreFilter();
		filter.setExcludes(EXLUDE_PATTERNS);
		JSON.toJSONString(user, filter);
	}
}
