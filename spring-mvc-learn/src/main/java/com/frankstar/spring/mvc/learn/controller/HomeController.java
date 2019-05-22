package com.frankstar.spring.mvc.learn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@RequestMapping
public class HomeController implements Controller {


	@Override
	public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) throws Exception {
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//指定视图
		modelAndView.setViewName("../hello");

		return modelAndView;
	}
}
