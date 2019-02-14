package com.frankstar.spring.mvc.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Controller
@RequestMapping
public class HelloController {


	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap modelMap) {
		modelMap.addAttribute("message", "hello frankstar!");

		return "hello";
	}
}
