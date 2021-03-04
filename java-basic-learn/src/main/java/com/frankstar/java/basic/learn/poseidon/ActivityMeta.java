package com.frankstar.java.basic.learn.poseidon;

import com.dianping.overseas.poseidon.utils.DateUtils;
import java.util.Date;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/1
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ActivityMeta {


	public static void main(String[] args) {
		for(int i=7; i>0; i--) {
			String dateKey = DateUtils.formatDate(DateUtils.addDays(new Date(), 0-i));
			System.out.println(dateKey);
		}
		System.out.println("------");

		for(int i=14; i>7; i--) {
			String dateKey = DateUtils.formatDate(DateUtils.addDays(new Date(), 0-i));
			System.out.println(dateKey);
		}
		System.out.println("------");
		String dateKey = DateUtils.formatDate(DateUtils.addDays(new Date(), -14));
		System.out.println(DateUtils.addDays(new Date(), -15));
		System.out.println("------");
		System.out.println(DateUtils.addDays(new Date(), -1));

	}
}
