package com.dianping.overseas.data.service.compute;

import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 减法操作
 */
@Component
public class MinusOperation extends Operation {

	@Override
	public Double operation() {
		return getHead() - getTail();
	}

	@Override
	public String opera() {
		return "-";
	}
}
