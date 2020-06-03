package com.dianping.overseas.data.service;

import com.dianping.overseas.poseidon.common.Response;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 数据运营指标服务 对接指标系统
 */
public interface DataOperationTagService {


	/**
	 * 根据规则与数据参数获取对应规则的运营数据
	 * @param params
	 * @param ruleId
	 * @return
	 */
	public Response loadAppOperationData(Map<String, Object> params, int ruleId);

}
