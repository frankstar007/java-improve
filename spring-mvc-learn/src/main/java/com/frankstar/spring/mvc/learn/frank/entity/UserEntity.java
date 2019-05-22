package com.frankstar.spring.mvc.learn.frank.entity;

import java.util.Date;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class UserEntity {
	private int id;

	/**
	 * 用户id
	 */
	private int userId;

	private String userName;

	private int age;

	private String userPassword;

	private Date birthday;

	private Date addTime;

	private Date updateTime;
}
