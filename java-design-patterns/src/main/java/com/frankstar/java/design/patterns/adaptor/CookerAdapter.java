package com.frankstar.java.design.patterns.adaptor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class CookerAdapter implements IWorkerAdapter {

	@Override
	public String work(Object worker) {
		return ((ICooker)worker).cook();
	}

	@Override
	public boolean isSupport(Object worker) {
		return worker instanceof ICooker;
	}
}
