package com.frankstar.spring.mvc.learn.controller;

import com.frankstar.spring.mvc.learn.dto.User;
import com.frankstar.spring.mvc.learn.frank.service.UserService;
import com.frankstar.spring.mvc.learn.utils.IdUtil;
import java.util.Date;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author :  frankstar
 * @AddTime :  2019/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Controller
@RequestMapping("/user")
public class UserController {


	@Resource
	private UserService userService;


	@RequestMapping(value = "register", method = RequestMethod.GET)
	public String registerForm() {
		//跳转登录界面
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(
		@RequestParam("password") String password,
		@RequestParam("username") String username) {

		//创建user对象
		User user = new User();
		user.setUserId(IdUtil.getId());
		user.setUserName(username);
		user.setBirthday(new Date());
		user.setPassword(password);

		userService.addUser(user);

		//跳转到登录页面
		return "loginForm";
	}

	@RequestMapping("/login")
	public String login(
		@RequestParam("username") String username,
		@RequestParam("password") String password,
		Model model) {
		User login = userService.login(username, password);
		if(login != null) {
			model.addAttribute("user", login);
			return "welcome";
		}
		//否则跳转到登录页
		return "loginForm";
	}

}
