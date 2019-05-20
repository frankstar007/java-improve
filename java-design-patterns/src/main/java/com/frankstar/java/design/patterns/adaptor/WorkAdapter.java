package com.frankstar.java.design.patterns.adaptor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class WorkAdapter {

	public String work(Object worker) {
		String workContent = "";
		if (worker instanceof ICooker) {
			workContent = ((ICooker) worker).cook();
		}
		if (worker instanceof IProgrammer) {
			workContent = ((IProgrammer) worker).programe();
		}
		return workContent;
	}
}
