package com.dianping.overseas.data.extension;

import com.dianping.overseas.data.annotation.Extension;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class ExtensionBuilder {

	private ExtensionBuilder() {
	}

	public static ExtensionBuilder getInstance() {
		return ExtensionBuilderInstance.INSTANCE;
	}

	private static class ExtensionBuilderInstance {
		private static final ExtensionBuilder INSTANCE = new ExtensionBuilder();

	}


	private Map<String, Process> extMap = new ConcurrentHashMap<>();


	/**
	 * 注册业务扩展类实例
	 */
	public void build() {
		Reflections extReflections = new Reflections("com.dianping.overseas.data.extension");
		Set<Class<?>> extClasses = extReflections.getTypesAnnotatedWith(Extension.class);

		try {
			for (Class<?> extClass : extClasses) {
				Extension[] extensions = extClass.getAnnotationsByType(Extension.class);
				if (extensions != null && extensions.length > 0) {
					Extension extension = extensions[0];
					extMap.put(extension.value(), (Process) extClass.newInstance());
				}
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}


	public Process getExt(String biz) {
		return extMap.get(biz);
	}

}
