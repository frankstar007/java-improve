package com.frankstar.java.basic.learn.enums;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public enum StudentType {

	//初级
	Junoir(1, "初级"),

	Senoir(2, "中极"),

	//高级
	Superior(3, "高级");

	private int code;

	private String memo;

	StudentType(int code, String memo) {
		this.code = code;
		this.memo = memo;
	}

	public static StudentType fromCode(int code) {
		for (StudentType studentType : StudentType.values()) {
			if (studentType.getCode() == code) {
				return studentType;
			}
		}
		return Junoir;
	}

	public int getCode() {
		return code;
	}

	public String getMemo() {
		return memo;
	}
}
