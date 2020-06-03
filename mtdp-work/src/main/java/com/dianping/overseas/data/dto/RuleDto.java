package com.dianping.overseas.data.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class RuleDto implements Serializable {

	/**
	 * 自增id
	 */
	private int id;
	/**
	 * 规则id
	 */
	private int ruleId;

	/**
	 * 数据来源
	 */
	private int dataOrigin;

	/**
	 * 数据应用
	 */
	private String appKey;

	/**
	 * 数据类型
	 */
	private int dataType;

	/**
	 * 时间维度
	 */
	private int timeScale;

	/**
	 * 数据指标
	 */
	private List<String> tags;

	/**
	 * 指标公式
	 */
	private String formula;

	/**
	 * 规则描述
	 */
	private String desc;

	/**
	 * 操作人
	 */
	private String operator;

}
