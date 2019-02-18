package com.frankstar.java.web.learn.servlet;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ConfigServlet extends HttpServlet {

	/**
	 * 定义servletConfig
	 */
	private ServletConfig servletConfig;

	@Override
	public void init(ServletConfig config) {
		this.servletConfig = config;
	}

	@Override
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		//获取在配置文件中的参数
		String param = this.servletConfig.getInitParameter("name");
		response.getWriter().println(param);

		response.getWriter().println("<hr/>");

		//获取所有的初始化参数
		Enumeration<String> params = servletConfig.getInitParameterNames();
		while (params.hasMoreElements()) {
			String para = params.nextElement();
			String paraValue = this.servletConfig.getInitParameter(para);
			response.getWriter().println(para + "=" + paraValue);
		}

		ServletContext servletContext = servletConfig.getServletContext();
		String data = (String) servletContext.getAttribute("sex");
		response.getWriter().println("sex = " + data );
	}
}
