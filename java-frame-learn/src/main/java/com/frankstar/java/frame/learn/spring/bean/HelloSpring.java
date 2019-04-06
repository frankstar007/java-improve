package com.frankstar.java.frame.learn.spring.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
@Slf4j
public class HelloSpring {

	private String name;

	public String sayHello() {
		log.info("Welcome to " + name + " spring world!");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name).append("say Hello to Spring");
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

}
