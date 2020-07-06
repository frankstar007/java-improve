package com.dianping.overseas.data.enums;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public enum DataType {

	EVENT(1, "event"),
	TRANSACTION(2, "transaction"),
	BUSINESS(3, "business"),
	API(4, "api");

	private int dataType;

	private String dataDesc;


	DataType(int type, String desc) {
		this.dataType = type;
		this.dataDesc = desc;
	}


	public static DataType fromCode(int code) {
		for (DataType dataType : DataType.values()) {
			if (dataType.getDataType() == code) {
				return dataType;
			}
		}
		return null;
	}

	public String getDataDesc() {
		return dataDesc;
	}

	public void setDataDesc(String dataDesc) {
		this.dataDesc = dataDesc;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}
}
