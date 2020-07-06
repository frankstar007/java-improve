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
public class CatEventData {

	private String avg;

	private String failCount;

	private String failPercent;

	private String key;

	private String max;

	private String name;

	private String sum;

	private String totalCount;

	private String tp50;

	private String tp90;

	private String tp95;

	private String tp99;

	private String tp999;

	private String tp9999;

	private String type;


	//private Map<Date, PeriodData> periods;


}
