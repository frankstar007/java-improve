package com.frankstar.java.basic.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.frankstar.java.basic.learn.example.Person;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.util.CollectionUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2020/2/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  chapter1
 * @Desc :
 */
public class GsonTest {


	private static String test = "{\n"
		+ "    \"orangeV\": {\n"
		+ "        \"A\": \"再写%d条100字点评可维持橙V\",\n"
		+ "        \"B\": \"VIP任务提示: %d条点评正在审核中\",\n"
		+ "        \"C\": \"%d条100字点评通过审核后可维持橙V\"\n"
		+ "    },\n"
		+ "    \"greyV\": {\n"
		+ "        \"A\": \"再写%d条100字点评可转为橙V\",\n"
		+ "        \"B\": \"VIP任务提示: %d条点评正在审核中\",\n"
		+ "        \"C\": \"%d条100字点评通过审核后可转为橙V\"\n"
		+ "    },\n"
		+ "    \"internV\": {\n"
		+ "        \"A\": \"再写%d条100字点评可转为橙V\",\n"
		+ "        \"B\": \"VIP任务提示: %d条点评正在审核中\",\n"
		+ "        \"C\": \"%d条100字点评通过审核后可转为橙V\"\n"
		+ "    },\n"
		+ "    \"nonV_Easy\": \"再写%d条点评可申请VIP\",\n"
		+ "    \"nonV_Hard\": \"再写%d条100字点评可申请VIP\"\n"
		+ "}";


	private static String persons = "[{\"firstName\":\"fank\",\"lastName\":\"star\"},{\"firstName\":\"zoe\",\"lastName\":\"star\"}]";


	private static String cityIds = "[{ \"skuId\": 2998, \"city\": \"日本\", }, { \"skuId\": 1545, \"city\": \"韩国\", }, { \"skuId\": 24067, \"city\": \"台湾\", }, { \"skuId\": 3176, \"city\": \"香港\", }, { \"skuId\": 1615, \"city\": \"泰国\", }, { \"skuId\": 11888, \"city\": \"欧洲\", }, { \"skuId\": 1595, \"city\": \"美国\", }, { \"skuId\": 2285, \"city\": \"澳新\", }, { \"skuId\": 3106, \"city\": \"日本\", }, { \"skuId\": 1697, \"city\": \"韩国\", }, { \"skuId\": 24067, \"city\": \"台湾\", }, { \"skuId\": 3172, \"city\": \"香港\", }, { \"skuId\": 1692, \"city\": \"泰国\", }, { \"skuId\": 2614, \"city\": \"欧洲\", }, { \"skuId\": 1698, \"city\": \"美国\", }, { \"skuId\": 1700, \"city\": \"澳新\", }, { \"skuId\": 3131, \"city\": \"日本\", }, { \"skuId\": 1863, \"city\": \"韩国\", }, { \"skuId\": 24067, \"city\": \"台湾\", }, { \"skuId\": 3196, \"city\": \"香港\", }, { \"skuId\": 1852, \"city\": \"泰国\", }, { \"skuId\": 2633, \"city\": \"欧洲\", }, { \"skuId\": 1869, \"city\": \"美国\", }, { \"skuId\": 2329, \"city\": \"澳新\", }, { \"skuId\": 17799, \"city\": \"日本\", }, { \"skuId\": 19551, \"city\": \"韩国\", }, { \"skuId\": 17670, \"city\": \"台湾\", }, { \"skuId\": 16210, \"city\": \"香港\", }, { \"skuId\": 17679, \"city\": \"泰国\", }, { \"skuId\": 15825, \"city\": \"欧洲\", }, { \"skuId\": 16391, \"city\": \"美国\", }, { \"skuId\": 2950, \"city\": \"澳新\", }, { \"skuId\": 3119, \"city\": \"日本\", }, { \"skuId\": 19546, \"city\": \"韩国\", }, { \"skuId\": 17686, \"city\": \"台湾\", }, { \"skuId\": 16279, \"city\": \"香港\", }, { \"skuId\": 17694, \"city\": \"泰国\", }, { \"skuId\": 2590, \"city\": \"欧洲\", }, { \"skuId\": 19141, \"city\": \"美国\", }, { \"skuId\": 2537, \"city\": \"澳新\", }, { \"skuId\": 3103, \"city\": \"日本\", }, { \"skuId\": 1544, \"city\": \"韩国\", }, { \"skuId\": 16306, \"city\": \"台湾\", }, { \"skuId\": 3170, \"city\": \"香港\", }, { \"skuId\": 16309, \"city\": \"泰国\", }, { \"skuId\": 2658, \"city\": \"欧洲\", }, { \"skuId\": 1591, \"city\": \"美国\", }, { \"skuId\": 16345, \"city\": \"澳新\", }, { \"skuId\": 2646, \"city\": \"日本\", }, { \"skuId\": 2799, \"city\": \"韩国\", }, { \"skuId\": 24067, \"city\": \"台湾\", }, { \"skuId\": 3194, \"city\": \"香港\", }, { \"skuId\": 2473, \"city\": \"泰国\", }, { \"skuId\": 2464, \"city\": \"欧洲\", }, { \"skuId\": 2466, \"city\": \"美国\", }, { \"skuId\": 2461, \"city\": \"澳新\", }, { \"skuId\": 22620, \"city\": \"日本\", }, { \"skuId\": 8862, \"city\": \"韩国\", }, { \"skuId\": 7600, \"city\": \"泰国\", }, { \"skuId\": 20842, \"city\": \"台湾\", }, { \"skuId\": 7087, \"city\": \"新加坡\", }, { \"skuId\": 7829, \"city\": \"马来西亚\", }, { \"skuId\": 6961, \"city\": \"澳大利亚\", }, { \"skuId\": 20588, \"city\": \"美国\", }, { \"skuId\": 23034, \"city\": \"日本\", }, { \"skuId\": 8875, \"city\": \"韩国\", }, { \"skuId\": 20619, \"city\": \"泰国\", }, { \"skuId\": 20842, \"city\": \"台湾\", }, { \"skuId\": 10585, \"city\": \"新加坡\", }, { \"skuId\": 16031, \"city\": \"马来西亚\", }, { \"skuId\": 7725, \"city\": \"澳大利亚\", }, { \"skuId\": 20585, \"city\": \"美国\", }, { \"skuId\": 8781, \"city\": \"日本\", }, { \"skuId\": 20071, \"city\": \"韩国\", }, { \"skuId\": 19576, \"city\": \"泰国\", }, { \"skuId\": 20842, \"city\": \"台湾\", }, { \"skuId\": 10585, \"city\": \"新加坡\", }, { \"skuId\": 8283, \"city\": \"马来西亚\", }, { \"skuId\": 9049, \"city\": \"澳大利亚\", }, { \"skuId\": 17883, \"city\": \"美国\", }, { \"skuId\": 21102, \"city\": \"日本\", }, { \"skuId\": 7104, \"city\": \"韩国\", }, { \"skuId\": 20728, \"city\": \"泰国\", }, { \"skuId\": 20842, \"city\": \"台湾\", }, { \"skuId\": 19821, \"city\": \"新加坡\", }, { \"skuId\": 21140, \"city\": \"马来西亚\", }, { \"skuId\": 6961, \"city\": \"澳大利亚\", }, { \"skuId\": 20596, \"city\": \"美国\", }, { \"skuId\": 10681, \"city\": \"韩国\", }, { \"skuId\": 3131, \"city\": \"日本\", }, { \"skuId\": 24067, \"city\": \"台湾\", }, { \"skuId\": 3538, \"city\": \"泰国\", }, { \"skuId\": 2470, \"city\": \"新加坡\", }, { \"skuId\": 2246, \"city\": \"越南\", }, { \"skuId\": 3556, \"city\": \"美国\", }, { \"skuId\": 27749, \"city\": \"欧洲\", }, { \"skuId\": 3155, \"city\": \"韩国\", }, { \"skuId\": 3106, \"city\": \"日本\", }, { \"skuId\": 3545, \"city\": \"泰国\", }, { \"skuId\": 1692, \"city\": \"泰国\", }, { \"skuId\": 2799, \"city\": \"韩国\", }, { \"skuId\": 2646, \"city\": \"日本\", }, { \"skuId\": 2473, \"city\": \"泰国\", }, { \"skuId\": 9278, \"city\": \"日本\", }, { \"skuId\": 3166, \"city\": \"韩国\", }, { \"skuId\": 18981, \"city\": \"韩国\", }, { \"skuId\": 3094, \"city\": \"韩国\", }, { \"skuId\": 24067, \"city\": \"台湾\", }, { \"skuId\": 16277, \"city\": \"香港\", }, { \"skuId\": 3170, \"city\": \"香港\", }, { \"skuId\": 3176, \"city\": \"香港\", }, { \"skuId\": 3101, \"city\": \"泰国\", }, { \"skuId\": 3616, \"city\": \"印尼\", }, { \"skuId\": 3790, \"city\": \"柬埔寨\", }, { \"skuId\": 3748, \"city\": \"欧洲\", }, { \"skuId\": 2648, \"city\": \"美加\", }, { \"skuId\": 3798, \"city\": \"越南\", }, { \"skuId\": 17839, \"city\": \"全球60国\", }, { \"skuId\": 3524, \"city\": \"泰国\", }, { \"skuId\": 3101, \"city\": \"新加坡\", }]";




	public static void main(String[] args) {

		HashMap<Integer, String> resultMap = new HashMap<Integer, String>();


		JSONArray array = JSON.parseArray(cityIds);
		if (CollectionUtils.isEmpty(array)){
			return;
		}
		for (Object object : array){
			int skuId = ((JSONObject)object).getIntValue("skuId");
			String city = ((JSONObject)object).getString("city");
			resultMap.put(skuId, city);
		}

		Gson gson = new Gson();
		Map<Integer, String> last = gson.fromJson(cityIds, new TypeToken<Map<Integer, String>>(){}.getType());


			JsonParser jsonParser = new JsonParser();
			JsonArray a = jsonParser.parse(cityIds).getAsJsonArray();

			if (array == null) {
				return;
			}

			JsonElement jsonElement = JsonParser.parseString(test);
			JsonObject jsonObject = jsonElement.getAsJsonObject();

			System.out.println(jsonObject.get("nonV_Easy").getAsJsonPrimitive().getAsString());

			Person one = new Person("fank", "star");
			Person two = new Person("zoe", "star");

			List<Person> personList = Lists.newArrayList(one, two);

			String objs = new Gson().toJson(personList);
			System.out.println(objs);

			List<Person> result = new Gson().fromJson(persons, new TypeToken<List<Person>>() {
			}.getType());
			System.out.println(result);
		}







}
