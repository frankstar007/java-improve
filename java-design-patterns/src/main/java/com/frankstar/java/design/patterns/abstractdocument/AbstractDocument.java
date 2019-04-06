package com.frankstar.java.design.patterns.abstractdocument;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public abstract class AbstractDocument implements Document{

	private final Map<String, Object> properties;


	protected AbstractDocument(Map<String, Object> properties) {
		Objects.requireNonNull(properties, "PropertiesMap is required!");
		this.properties = properties;
	}

	@Override
	public void put(String key, Object value) {
		properties.put(key, value);
	}

	@Override
	public Object get(String key) {
		return properties.get(key);
	}

	@Override
	public <T> Stream<T> children(String key, Function<Map<String, Object>, T> constructor) {
		Optional<List<Map<String, Object>>> result = Stream.of(get(key)).filter(Objects::nonNull)
			.map(el -> (List<Map<String, Object>>) el).findAny();
		return result.map(maps -> maps.stream().map(constructor)).orElseGet(Stream::empty);
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(getClass().getName()).append("[");
		properties.entrySet().forEach(e -> stringBuilder.append("[").append(e.getKey())
		.append(":").append(e.getValue()).append("]"));
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
}
