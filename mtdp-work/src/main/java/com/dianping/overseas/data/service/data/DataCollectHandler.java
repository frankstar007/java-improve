package com.dianping.overseas.data.service.data;

import com.dianping.overseas.data.dto.RuleDto;
import com.dianping.overseas.poseidon.common.Response;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface DataCollectHandler {


	public int loadDataType(RuleDto ruleDto);


	public Response loadData(RuleDto ruleDto, Map<String, String> prams);


}
