package com.dianping.overseas.data.utils;

import com.dianping.overseas.data.data.PeriodData;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class MyDateDeSerializer implements JsonDeserializer<Map<Long, PeriodData>> {



	@Override
	public Map<Long, PeriodData> deserialize(JsonElement jsonElement, Type type,
		JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
		Map<Long, PeriodData> result = new HashMap<>();
		jsonElement.getAsJsonObject().entrySet().forEach(
			e -> {
				long time = DateUtil.getTime(e.getKey());
				Gson gson = new Gson();
				PeriodData periodData = gson.fromJson(e.getValue(), PeriodData.class);
				result.put(time, periodData);

			}
		);
		return result;
	}
}
