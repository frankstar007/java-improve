package com.frankstar.java.frame.learn.netty.basic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author :  frankstar
 * @AddTime :  2020/10/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class TimeServer {


	public static void main(String[] args) throws IOException {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			}catch (Exception e) {

			}
		}

		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);

			Socket socket = null;
			while (true) {
				socket = serverSocket.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} catch (Exception e) {

		} finally {
			if (serverSocket != null) {
				System.out.println("server close");
				serverSocket.close();
				serverSocket = null;
			}
		}
	}
}
