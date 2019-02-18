package com.frankstar.java.web.learn.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
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
public class ContextServlet extends HttpServlet {

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
		String sex = "female";
		ServletContext context = this.getServletConfig().getServletContext();
		context.setAttribute("sex", sex);

//		Enumeration<String> stringEnumeration = context.getAttributeNames();
//		while (stringEnumeration.hasMoreElements()) {
//			String attribute = stringEnumeration.nextElement();
//			response.getWriter().println(attribute + "------" + context.getAttribute(attribute));
//		}
		String data = "context forward to root";
		response.getOutputStream().write(data.getBytes());

		//实现请求转发
		RequestDispatcher requestDispatcher = context.getRequestDispatcher("/");
		requestDispatcher.forward(request, response);

		//实现资源读取
		response.setHeader("content-type", "text/html;charset=UTF-8");
		//读取resouce目录下的文件资源
		readFile(response);
		response.getWriter().println("<hr/>");
		//读取WebApp目录下的properties配置文件
		readFile(response);
		response.getWriter().println("<hr/>");
		//读取类目录下的配置文件
		readFile(response);

	}

	private void readFile(HttpServletResponse response) throws IOException {
		InputStream inputStream = this.getServletContext().getResourceAsStream("db/db.config");
		Properties properties = new Properties();
		properties.load(inputStream);

	}
}
