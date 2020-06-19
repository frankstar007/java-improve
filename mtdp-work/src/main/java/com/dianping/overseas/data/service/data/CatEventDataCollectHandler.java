package com.dianping.overseas.data.service.data;

import com.dianping.overseas.data.data.CatData;
import com.dianping.overseas.data.data.CatEventData;
import com.dianping.overseas.data.data.CatRequest;
import com.dianping.overseas.data.data.PeriodData;
import com.dianping.overseas.data.dto.RuleDto;
import com.dianping.overseas.data.enums.DataType;
import com.dianping.overseas.data.enums.TimeScaleEnum;
import com.dianping.overseas.data.utils.MyDateDeSerializer;
import com.dianping.overseas.poseidon.common.Response;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class CatEventDataCollectHandler implements DataCollectHandler {

	@Override
	public int loadDataType(RuleDto ruleDto) {
		return ruleDto.getDataType();
	}

	@Override
	public Response loadData(RuleDto ruleDto, Map<String, String> paramsMap) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("domain",ruleDto.getAppKey());
		params.add("reportName", DataType.fromCode(ruleDto.getDataType()).getDataDesc());

		params.add("params", ruleDto.getParams());
		params.add("op", "queryBatchData");

		params.add("startDate",paramsMap.get("startDate"));
		params.add("endDate", paramsMap.get("endDate"));
		params.add("queryType", TimeScaleEnum.fromCode(ruleDto.getTimeScale()).getDesc());


		String response = CatRequest.sendPostRequest(params);
		//构建objectNode
		try {
			//使用gson解析

			JsonElement element = JsonParser.parseString(response);
			JsonObject jsonObject = element.getAsJsonObject();
			JsonObject data = jsonObject.getAsJsonObject("data");
			JsonObject domains = data.getAsJsonObject("domains");
			JsonObject app = domains.getAsJsonObject("poseidon-order-service");
			JsonObject machines = app.getAsJsonObject("machines");
			JsonObject all = machines.getAsJsonObject("All");
			JsonObject queryItem = all.getAsJsonObject("queryItems");
			JsonObject catEvent = queryItem.getAsJsonObject(ruleDto.getRuleKey());

			Type typeToken = new TypeToken<Map<Long, PeriodData>>(){}.getType();
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.registerTypeAdapter(typeToken, new MyDateDeSerializer()).create();
			CatEventData catEventData = gson.fromJson(catEvent, CatEventData.class);

			JsonObject periodsObject = catEvent.getAsJsonObject("periods");
			Map<Long, PeriodData> periods = gson.fromJson(periodsObject, typeToken);
			System.out.println(periods);
			List<CatData> catDatas = Lists.newArrayList();
			if (MapUtils.isNotEmpty(periods)) {
				periods.forEach((key, value) -> {
					CatData catData = CatData.builder().time(key).count(
						Double.parseDouble(value.getCount())).build();
					catDatas.add(catData);
				});
			}
			System.out.println(catDatas);
			return Response.successResponse(catDatas);

		} catch (Exception e) {
			log.error("", e);
		}
		return Response.successResponse(null);
	}


	public static void main(String[] args) {
		CatEventDataCollectHandler handler = new CatEventDataCollectHandler();
		RuleDto ruleDto = new RuleDto();
		ruleDto.setAppKey("poseidon-order-service");
		ruleDto.setDataType(1);
		ruleDto.setDataOrigin("cat");
		ruleDto.setTimeScale(4);
		ruleDto.setRuleKey("SQL.Method-SELECT");
		ruleDto.setParams("[{\"type\":\"SQL.Method\",\"names\":[\"SELECT\"]}]");
		Map<String, String> dateParams = new HashMap<>();
		dateParams.put("startDate", "20200615");
		dateParams.put("endDate", "20200616");
		handler.loadData(ruleDto, dateParams);



	}
}
