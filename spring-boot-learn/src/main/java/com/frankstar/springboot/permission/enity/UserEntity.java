package com.frankstar.springboot.permission.enity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/6/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class UserEntity implements Serializable {

	private int id;

	private int userId;

	private String login;

	private String password;

	private String userName;

	private String address;

	private String job;

	private Date birthday;

	private int cityId;

	private String cityName;

	private String district;

	private String province;

	private String streetAddress;

	private String state;

	private int type;

	private Date lastLoginDate;

	private Date addTime;

	private Date updateTime;
}
