package com.frankstar.spring.boot.deep.extend;

import com.frankstar.spring.boot.deep.annotation.Extensible;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 跟踪扩展点
 */
@Extensible
public interface TraceExtension extends AbstractExtension {


	void trace(String params, StringBuilder context);
}
