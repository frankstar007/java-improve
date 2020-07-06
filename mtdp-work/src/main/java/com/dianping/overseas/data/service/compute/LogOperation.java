package com.dianping.overseas.data.service.compute;

import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 计算对数
 */
@Component
public class LogOperation extends Operation {

	@Override
	public Double operation() {
		return Math.log(getHead()) / Math.log(getTail());
	}

	@Override
	public String opera() {
		return "log";
	}
}
