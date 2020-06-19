package com.dianping.overseas.data.dto;

import java.util.List;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class TagRuleDto {

	private int id;

	/**
	 * 指标id
	 */
	private int tagId;


	/**
	 * 指标名称
	 */
	private String tagName;

	/**
	 * 指标规则
	 */
	private List<Integer> rules;


	/**
	 * 计算公式
	 */
	private String formula;

	/**
	 * 展示类型
	 */
	private int showType;

	/**
	 * 监控类型
	 */
	private int monitorRule;
}
