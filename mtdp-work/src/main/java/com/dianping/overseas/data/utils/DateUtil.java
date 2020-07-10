package com.dianping.overseas.data.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class DateUtil {


	private static String pattern1 = "yyyy-MM-dd HH:mm:ss";

	private static String pattern2 = "yyyy-MM-dd HH:mm";

	private static String pattern3 = "yyyy-MM-dd HH";

	private static String pattern4 = "yyyy-MM-dd";

	public static long  getTime(String timeStr) {

		try {
			long time = DateUtils
				.parseDate(timeStr, new String[]{pattern1, pattern2, pattern3, pattern4}).getTime();
			return time;
		} catch (Exception e) {
			log.error("", e);
		}

		return 0;
	}
}
