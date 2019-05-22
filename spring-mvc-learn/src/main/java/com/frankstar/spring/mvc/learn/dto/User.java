package com.frankstar.spring.mvc.learn.dto;

import java.io.Serializable;
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
public class User implements Serializable {

	private int id;

	private int userId;

	private String password;

	private String userName;

	private int age;

	private Date birthday;
}
