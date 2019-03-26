package com.frankstar.spring.mvc.learn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frankstar.spring.mvc.learn.dto.Item;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import java.util.List;


/**
 * @Author :  frankstar
 * @AddTime :  2019/2/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@RequestMapping
public class HelloController implements Controller {


	@Override
	public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		//调用service查找数据库，查询商品列表，这里使用静态数据模拟
		List<Item> itemsList = Lists.newArrayList();

		//向list中填充静态数据
		Item items_1 = new Item();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Item items_2 = new Item();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);

		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//相当于request的setAttribute方法,在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		//指定视图
		modelAndView.setViewName("/WEB-INF/view/items/itemsList.jsp");

		return modelAndView;

	}
}
