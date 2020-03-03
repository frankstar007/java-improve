package com.frankstar.java.basic.learn.json;

import com.frankstar.java.basic.learn.example.Person;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.util.List;

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



	public static void main(String[] args) {
		JsonElement jsonElement = JsonParser.parseString(test);
		JsonObject jsonObject = jsonElement.getAsJsonObject();

		System.out.println(jsonObject.get("nonV_Easy").getAsJsonPrimitive().getAsString());

		Person one = new Person("fank", "star");
		Person two = new Person("zoe", "star");

		List<Person> personList = Lists.newArrayList(one, two);

		String objs = new Gson().toJson(personList);
		System.out.println(objs);


		List<Person> result = new Gson().fromJson(persons, new TypeToken<List<Person>>(){}.getType());
		System.out.println(result);

	}

}
