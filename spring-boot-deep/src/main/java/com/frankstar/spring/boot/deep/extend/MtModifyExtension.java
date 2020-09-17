package com.frankstar.spring.boot.deep.extend;

import com.frankstar.spring.boot.deep.annotation.Extension;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Extension("mt")
public class MtModifyExtension implements ModifyExtension {

	@Override
	public void modify(String params, StringBuilder context) {
		System.out.println("mt modify");
		context.append("mt modify -");
	}
}
