package com.dianping.overseas.data.service.compute;

import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 计算类
 */
@Data
public abstract class Operation {

	/**
	 * 头操作数
	 */
	private Double head;

	/**
	 * 尾操作数
	 */
	private Double tail;


	/**
	 * 计算
	 * @return
	 */
	public abstract Double operation();


	/**
	 * 获取操作符
	 * @return
	 */
	public abstract String opera();
}
