package com.frankstar.java.basic.learn.json;

import com.alibaba.fastjson.JSONObject;
import com.dianping.overseas.poseidon.utils.JsonUtils;
import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class JacksonUtil {

	@Data
	class RichTextItem {
		/**
		 * 文本
		 */
		private final String text;

		/**
		 * 文字颜色值 eg:#FF6633
		 */
		private final String textcolor;

		/**
		 * 文字字号 eg:10
		 */
		private final String textsize;

		public RichTextItem(String text, String textcolor, String textsize) {
			super();
			this.text = text;
			this.textcolor = textcolor;
			this.textsize = textsize;
		}
	}

	public static String getRichTextList(List<RichTextItem> richTextItemList, String lineSpacing, String alignment) {
		List<RichTextItem> notBlankRichTextItemList = Lists.newArrayList();
		for (RichTextItem richTextItem : richTextItemList) {
			if (StringUtils.isNotBlank(richTextItem.getText())) {
				notBlankRichTextItemList.add(richTextItem);
			}
		}
		if (CollectionUtils.isEmpty(notBlankRichTextItemList)) {
			return "";
		}
		Map<String, Object> result = new HashMap<>();
		result.put("richtextlist", notBlankRichTextItemList);
		result.put("linespacing", lineSpacing);
		result.put("alignment", alignment);
		return JsonUtils.objectToJson(result);
	}

	public static String getRichTextList2(List<RichTextItem> richTextItemList, String lineSpacing, String alignment) {
		List<RichTextItem> notBlankRichTextItemList = Lists.newArrayList();
		for (RichTextItem richTextItem : richTextItemList) {
			if (StringUtils.isNotBlank(richTextItem.getText())) {
				notBlankRichTextItemList.add(richTextItem);
			}
		}
		if (CollectionUtils.isEmpty(notBlankRichTextItemList)) {
			return "";
		}
		JSONObject result = new JSONObject();
		result.put("richtextlist", notBlankRichTextItemList);
		result.put("linespacing", lineSpacing);
		result.put("alignment", alignment);
		return result.toJSONString();
	}


	public static void main(String[] args) {
		JacksonUtil jacksonUtil = new JacksonUtil();
		List<RichTextItem> richTextItems = Lists.newArrayList();
		RichTextItem richTextItem = jacksonUtil.new RichTextItem("test", "red", "10");
		RichTextItem richTextItem2 = jacksonUtil.new RichTextItem("test2", "red1", "11");

		richTextItems.add(richTextItem);
		richTextItems.add(richTextItem2);
		String result = JacksonUtil.getRichTextList(richTextItems, "20", "居中");
		String fast = JacksonUtil.getRichTextList2(richTextItems, "15", "左对齐");
		System.out.println(result);
		System.out.println(fast);

	}


}
