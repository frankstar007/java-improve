package com.frankstar.java.design.patterns.adaptor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class HmjCooker implements ICooker {

	@Override
	public String cook() {
		return "黄焖鸡师傅！";
	}
}
