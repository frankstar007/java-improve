package com.dianping.overseas.data.service.data;

import com.dianping.overseas.data.data.CatData;
import com.dianping.overseas.data.data.CatRequest;
import com.dianping.overseas.data.dto.RuleDto;
import com.dianping.overseas.data.enums.DataType;
import com.dianping.overseas.data.enums.TimeScaleEnum;
import com.dianping.overseas.poseidon.common.Response;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class CatBusinessDataCollectHandler implements DataCollectHandler {

	@Override
	public int loadDataType(RuleDto ruleDto) {
		return ruleDto.getDataType();
	}

	@Override
	public Response loadData(RuleDto ruleDto, Map<String, String> prams) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("domain", ruleDto.getAppKey());
		params.add("reportName", DataType.fromCode(ruleDto.getDataType()).getDataDesc());
		params.add("op", "businessDatas");
		params.add("itemId", ruleDto.getRuleKey());
		params.add("params", ruleDto.getParams());
		params.add("queryType", TimeScaleEnum.fromCode(ruleDto.getTimeScale()).getDesc());
		String response = CatRequest.sendPostRequest(params);


		//构建objectNode
		try {
			JsonElement element = JsonParser.parseString(response);
			JsonArray array = element.getAsJsonArray();
			//默认取第一个
			JsonObject jsonObject = array.get(0).getAsJsonObject();
			JsonObject data = jsonObject.getAsJsonObject("datas");
			JsonObject periods = data.getAsJsonObject(ruleDto.getRuleKey());
			List<CatData> catDataList = Lists.newArrayList();
			periods.entrySet().forEach(
				ele -> {
					String value = ele.getValue().getAsString();
					CatData catData = CatData.builder().time(Long.parseLong(ele.getKey())).count(
						Double.parseDouble(value)).build();

					catDataList.add(catData);
				}
			);
			System.out.println(catDataList);
			return Response.successResponse(catDataList);

		} catch (Exception e) {
			log.error("", e);
		}
		return Response.errorResponse("parse error!");
	}


	public static void main(String[] args) {
		CatBusinessDataCollectHandler handler = new CatBusinessDataCollectHandler();
		RuleDto ruleDto = new RuleDto();
		ruleDto.setAppKey("poseidon-order-service");
		ruleDto.setDataType(DataType.BUSINESS.getDataType());
		ruleDto.setTimeScale(TimeScaleEnum.DAY.getTime());
		ruleDto.setRuleKey("pandora_notify");

		Map<String, String> dateParams = new HashMap<>();
		dateParams.put("startDate", "20200611");
		dateParams.put("endDate", "20200612");
		handler.loadData(ruleDto, dateParams);
	}
}
