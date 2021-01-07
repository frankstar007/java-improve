package com.frankstar.java.basic.learn.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 读取文件测试
 */
public class SkuNameRead {

	class RecordName {
		private String originName;
		private String ruleRecordName;
		private String standardName;
	}

	public String read(File file) throws IOException {

		StringBuilder builder = new StringBuilder();
		FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String str = null;
		while((str = bufferedReader.readLine()) != null)
		{
			builder.append(str);
		}

		//close
		inputStream.close();
		bufferedReader.close();
		return builder.toString();
	}


	public static void main(String[] args) {

	}

}
