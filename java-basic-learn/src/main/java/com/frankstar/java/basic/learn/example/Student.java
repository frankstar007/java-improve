package com.frankstar.java.basic.learn.example;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author :  frankstar
 * @AddTime :  2019/3/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	private int age;

	private String name;

	private Date birthday;

	private String code;


	public String getAge(int gap) {
		return String.valueOf(age + gap);
	}

}
