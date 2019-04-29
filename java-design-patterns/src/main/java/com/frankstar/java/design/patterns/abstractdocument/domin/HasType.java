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
public interface HasType extends Document {

	String PROPERTY = "type";

	default Optional<String> getType() {
		return Optional.ofNullable((String) get(PROPERTY));
	}

}
