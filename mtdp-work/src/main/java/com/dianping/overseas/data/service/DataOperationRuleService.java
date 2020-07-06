package com.dianping.overseas.data.service;

import com.dianping.overseas.data.dto.RuleDto;
import com.dianping.overseas.poseidon.common.Response;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface DataOperationRuleService {

	/**
	 * 新增规则
	 * @param ruleDto
	 * @return
	 */
	public Response addRule(RuleDto ruleDto);


	/**
	 * 更新规则
	 * @param ruleDto
	 * @return
	 */
	public Response updateRule(RuleDto ruleDto);


	/**
	 * 查询规则
	 * @param ruleDto
	 * @return
	 */
	public Response loadRule(RuleDto ruleDto);

}
