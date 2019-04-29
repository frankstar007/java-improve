package com.frankstar.java.design.patterns.abstractdocument.domin;

import com.frankstar.java.design.patterns.abstractdocument.Document;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface HasParts extends Document{

	String PROPERTY = "parts";

	default Stream<Part> getParts() {
		return children(PROPERTY, Part::new);
	}

}
