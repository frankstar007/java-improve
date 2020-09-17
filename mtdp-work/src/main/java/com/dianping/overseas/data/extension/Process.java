package com.dianping.overseas.data.extension;

import com.dianping.overseas.data.annotation.Extensible;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 扩展点
 */
@Extensible
public interface Process {

	void beforeProcess(String params, StringBuilder processContext);


	void afterProcess(String params, StringBuilder processContext);
}
