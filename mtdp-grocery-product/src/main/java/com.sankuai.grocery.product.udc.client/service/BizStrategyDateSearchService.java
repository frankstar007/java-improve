package com.sankuai.grocery.product.udc.client.service;

import com.facebook.swift.service.ThriftMethod;
import com.meituan.servicecatalog.api.annotations.ExceptionDoc;
import com.meituan.servicecatalog.api.annotations.ExtensionDoc;
import com.meituan.servicecatalog.api.annotations.MethodDoc;
import com.meituan.servicecatalog.api.annotations.ParamDoc;
import com.sankuai.grocery.product.udc.client.response.BizStrategyDataRespDTO;
import com.sankuai.grocery.product.udc.client.response.SearchBizStrategyDataRequest;
import com.sankuai.grocery.product.udc.client.response.SearchBizStrategyDataResponse;
import org.apache.thrift.TException;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface BizStrategyDateSearchService {


	@MethodDoc(
		displayName = "获取某个策略规则的自定义数据集",
		description = "获取某个策略规则的自定义数据集",
		parameters = {
			@ParamDoc(name = "request", description = "请求request")
		},
		returnValueDescription = "SearchBizStrategyDataRequest,包含commonResp描述成功与否,BizStrategyDataRespDTO",
		exceptions = {
			@ExceptionDoc(type = TException.class, description = "异常信息")
		},
		extensions = {
			@ExtensionDoc(name = "SECURITY_PRIVILEGE", content = "不需要鉴权")
		}
	)
	@ThriftMethod
	SearchBizStrategyDataResponse searchBizStragtegyData(SearchBizStrategyDataRequest request) throws TException;
}
