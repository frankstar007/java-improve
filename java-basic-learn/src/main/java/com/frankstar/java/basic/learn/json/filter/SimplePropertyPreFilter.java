package com.frankstar.java.basic.learn.json.filter;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import java.util.Set;
import java.util.regex.Pattern;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/7/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class SimplePropertyPreFilter implements PropertyPreFilter {

	private Set<Pattern> includes;
	private Set<Pattern> excludes;



	@Override
	public boolean apply(JSONSerializer jsonSerializer, Object source, String name) {
		if (source == null) {
			return true;
		}

		for (Pattern exclude: excludes) {
			if (exclude.matcher(name).matches()) {
				return false;
			}
		}

		if (CollectionUtils.isEmpty(includes)) {
			return true;
		}
		for (Pattern include: includes) {
			if (include.matcher(name).matches()) {
				return true;
			}
		}

		return false;
	}

	public void setExcludes(Set<Pattern> excludes) {
		this.excludes = excludes;
	}

	public void setIncludes(Set<Pattern> includes) {
		this.includes = includes;
	}
}
