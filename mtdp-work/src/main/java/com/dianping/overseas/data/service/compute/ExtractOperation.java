package com.dianping.overseas.data.service.compute;

import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  开方操作
 */
@Component
public class ExtractOperation extends Operation {

	@Override
	public Double operation() {
		if (getTail() == 0) return 1.0;
		return Math.pow(getHead(), 1/getTail());
	}

	@Override
	public String opera() {
		return "√";
	}
}
