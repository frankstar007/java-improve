package com.frankstar.java.design.patterns.adaptor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ProgrammerAdapter implements IWorkerAdapter {

	@Override
	public String work(Object worker) {
		return ((IProgrammer)worker).programe();
	}

	@Override
	public boolean isSupport(Object worker) {
		return worker instanceof IProgrammer;
	}
}
