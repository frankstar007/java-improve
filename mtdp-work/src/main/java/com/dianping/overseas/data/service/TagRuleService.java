package com.dianping.overseas.data.service;

import com.dianping.overseas.data.dto.TagRuleDto;
import com.dianping.overseas.poseidon.common.Response;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 数据运营指标规则
 */
public interface TagRuleService {


	/**
	 * 添加指标-规则
	 * @param tagRuleDto
	 * @return
	 */
	Response addTagRule(TagRuleDto tagRuleDto);


	/**
	 * 更新指标规则信息
	 * @param tagRuleDto
	 * @return
	 */
	Response updateTagRule(TagRuleDto tagRuleDto);


	/**
	 * 根据指标id 获取指标配置信息
	 * @param tagId
	 * @return
	 */
	Response loadTagRule(String tagId);


	/**
	 * 计算指标数据
	 * @param tagId
	 * @return
	 */
	Response computeTag(String tagId);

}
