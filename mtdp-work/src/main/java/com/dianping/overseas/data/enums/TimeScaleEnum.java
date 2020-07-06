package com.dianping.overseas.data.enums;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 时间维度
 */
public enum TimeScaleEnum {

	MINIUTE(1, "minute"),
	HOUR(2, "hour"),
	DAY(3, "day"),
	WEEK(4,"week"),
	MONTH(5,"month");

	private int time;

	private String desc;

	TimeScaleEnum(int time, String desc) {
		this.time = time;
		this.desc = desc;
	}

	public static TimeScaleEnum fromCode(int code) {
		for (TimeScaleEnum timeScaleEnum : TimeScaleEnum.values()) {
			if (code == timeScaleEnum.getTime()) {
				return timeScaleEnum;
			}
		}
		return null;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
}
