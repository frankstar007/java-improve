package com.frankstar.java.web.learn.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class CacheServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		String datq = "cache content";
		response.setDateHeader("expires", System.currentTimeMillis() + 24*3600*1000);
		response.getOutputStream().write(datq.getBytes());
	}
}
