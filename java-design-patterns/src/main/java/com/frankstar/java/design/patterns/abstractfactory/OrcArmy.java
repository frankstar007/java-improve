package com.frankstar.java.design.patterns.abstractfactory;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class OrcArmy implements Army {

	private static final String DESCRIPTION = "This is Orc Army!";

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
