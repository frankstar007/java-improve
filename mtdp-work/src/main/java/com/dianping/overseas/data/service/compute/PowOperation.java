package com.dianping.overseas.data.service.compute;

import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 乘方操作
 */
@Component
public class PowOperation extends Operation {

	@Override
	public Double operation() {
		return Math.pow(getHead(), getTail());
	}

	@Override
	public String opera() {
		return "^";
	}
}
