package com.dianping.overseas.data.data;

import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class PeriodData {

	private String avg;

	private String count;

	private String failCount;

	private String failPercent;

	private String id;

	private String max;

	private String successPercent;

	private String sum;

	private String tp50;

	private String tp90;

	private String tp99;

	private String tp999;

	private String tp9999;
}
