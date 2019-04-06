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
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

	public Car(Map<String, Object> properties) {
		super(properties);
	}
}
