package com.frankstar.java.basic.learn.json;

import lombok.Data;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/7/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class User {

	private long userId;

	private String userName;

	private String passoword;

	private Double lat;

	private Double lng;

}
