package com.frankstar.spring.boot.deep.extend;

import com.frankstar.spring.boot.deep.annotation.Extensible;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 更新扩展点
 */
@Extensible
public interface ModifyExtension extends AbstractExtension {


	void modify(String params, StringBuilder context);
}
