package com.frankstar.java.frame.learn.spring.bean;

import javax.inject.Named;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : Named与Component注解差不多，但是一般不使用改注解，没有表明自己是做什么的
 */
@Data
@Slf4j
@Named
public class HelloSpring {

	private String name;

	public String sayHello() {
		log.info("Welcome to " + name + " spring world!");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(name).append(" say Hello to Spring");
		System.out.println(stringBuilder.toString());
		return stringBuilder.toString();
	}

}
