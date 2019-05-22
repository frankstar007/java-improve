package com.frankstar.spring.mvc.learn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : FrankController是一个基于注解的控制器
 * 	可以同时处理多个请求动作，并且无需实现任何接口
 */
@Slf4j
@Controller
public class FrankController {

	@RequestMapping("/")
	public String home() {
		return "hello";
	}


}
