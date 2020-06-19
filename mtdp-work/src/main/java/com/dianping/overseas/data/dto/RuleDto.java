package com.dianping.overseas.data.dto;

import java.io.Serializable;
import java.util.Date;
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
	 * 规则id
	 */
	private long ruleId;

	/**
	 * 规则名称与描述
	 */
	private String ruleName;


	/**
	 * 数据来源类型
	 * 1. cat
	 * 2. radar
	 */
	private int dataOriginType;

	/**
	 * cat
	 * radar
	 */
	private String dataOrigin;

	/**
	 * 数据类型
	 * 1.catEvent
	 * 2.catBusiness
	 * 3.catTransaction
	 * 4.catApi
	 */
	private int dataType;

	/**
	 * 应用名称
	 */
	private String appKey;

	/**
	 * 时间维度
	 * 1. 实时
	 * 2. 秒
	 * 3. 分
	 * 4. 时
	 * 5. 天
	 * 6. 周
	 * 7. 月
	 */
	private int timeScale;


	/**
	 * 必选参数
	 */
	private String params;

	/**
	 * 操作人mis号
	 */
	private String operator;

	/**
	 * 1 线下
	 * 2 审核
	 * 3 线上
	 */
	private int status;

	/**
	 * 新增时间
	 */
	private Date addTime;


	/**
	 * 除了参数外的key
	 */
	private String ruleKey;
}
