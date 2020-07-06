package com.frankstar.java.basic.learn.json;

import com.alibaba.fastjson.JSONObject;
import com.dianping.overseas.poseidon.common.LionUtils;
import com.dianping.overseas.poseidon.utils.JsonUtils;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/1
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class JacksonTest {


	public static void main(String[] args) {
		try {
			String json = LionUtils.getStringProperty("overseas-deal-api-web.deal.operate.tag");
			String test = "{\"1344784\":\"买大送小\"}";
			Map<Integer, String> last = JSONObject.parseObject(test, Map.class);
			Map<Integer, String> result = JsonUtils.jsonToObject(test, Map.class);
			System.out.println(result);
			System.out.println(last);
		}catch (Exception e) {
			log.error("", e);
		}

	}
}
