package com.frankstar.spring.boot.deep.extend;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 扩展门面暴露所有的扩展点
 */
public interface ExtensionFacade {


	ProcessExtension getProcess();


	ModifyExtension getModify();


	TraceExtension getTrace();
}
