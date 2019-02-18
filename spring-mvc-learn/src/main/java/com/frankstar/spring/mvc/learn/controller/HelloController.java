package com.frankstar.spring.mvc.learn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@RequestMapping
public class HelloController implements Controller {


	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String hello(ModelMap modelMap) {
		modelMap.addAttribute("message", "hello frankstar!");

		return "hello";
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		return null;
	}
}
