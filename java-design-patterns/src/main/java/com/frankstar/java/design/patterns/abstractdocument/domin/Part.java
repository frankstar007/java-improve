package com.frankstar.java.design.patterns.abstractdocument.domin;

import com.frankstar.java.design.patterns.abstractdocument.AbstractDocument;
import java.util.Map;


/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public  class  Part extends AbstractDocument implements HasType, HasModel, HasPrice {

	public Part(Map<String, Object> stringObjectMap) {
		super(stringObjectMap);
	}
}
