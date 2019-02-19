package com.frankstar.java.web.learn.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 生成随机验证码
 */
public class GeneratePicServlet extends HttpServlet {

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

		//设置响应头每4s刷新一次
		response.setHeader("refresh", "4");
		//内存中创建一张图片
		BufferedImage bufferedImage = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
		//得到图片
		Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
		graphics2D.setColor(Color.WHITE);
		graphics2D.fillRect(0, 0, 80, 20); //设置填充色
		graphics2D.setColor(Color.BLUE);
		graphics2D.setFont(new Font(null, Font.BOLD, 20));
		graphics2D.drawString(randomNum(), 0, 20);

		//设置不要缓存数据
		response.setDateHeader("expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");

		//将图片给浏览器
		ImageIO.write(bufferedImage, "gif", response.getOutputStream());



	}

	private static String randomNum() {
		Random random = new Random();
		String num = random.nextInt(9999) + "";
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i< 4 - num.length(); i++) {
			stringBuilder.append(0);
		}
		num = stringBuilder.toString() + num;

		return num;
	}


}
