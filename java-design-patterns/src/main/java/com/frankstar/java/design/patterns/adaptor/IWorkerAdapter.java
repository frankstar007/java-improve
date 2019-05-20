package com.frankstar.java.design.patterns.adaptor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface IWorkerAdapter {
	String work(Object worker);

	boolean isSupport(Object worker);

}
