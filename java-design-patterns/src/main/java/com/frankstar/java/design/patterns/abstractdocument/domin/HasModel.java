package com.frankstar.java.design.patterns.abstractdocument.domin;

import com.frankstar.java.design.patterns.abstractdocument.Document;
import java.util.Optional;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface HasModel extends Document {

	String PROPERTY = "model";

	default Optional<String> getModel() {
		return Optional.ofNullable((String) get(PROPERTY));
	}
}
