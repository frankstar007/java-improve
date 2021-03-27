package com.sankuai.grocery.product.udc.client.service;

import com.facebook.swift.service.ThriftMethod;
import com.meituan.servicecatalog.api.annotations.ExceptionDoc;
import com.meituan.servicecatalog.api.annotations.ExtensionDoc;
import com.meituan.servicecatalog.api.annotations.MethodDoc;
import com.meituan.servicecatalog.api.annotations.ParamDoc;
import com.sankuai.grocery.product.udc.client.model.BizDataFindReqDTO;
import com.sankuai.grocery.product.udc.client.model.BizDataSetFindRespDTO;
import com.sankuai.grocery.product.udc.client.response.BizStrategyDataRespDTO;
import org.apache.thrift.TException;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface SPIBizDataQueryService {

	@MethodDoc(
		displayName = "获取业务某个策略规则的自定义数据集",
		description = "获取业务某个策略规则的自定义数据集",
		parameters = {
			@ParamDoc(name = "BizDataFindReqDTO", description = "请求DTO,bizDataFindReqDTO")
		},
		returnValueDescription = "BizDataSetFindRespDTO,包含commonResp描述成功与否,bizDataSetDTOList返回的数据集列表",
		exceptions = {
			@ExceptionDoc(type = TException.class, description = "异常信息")
		},
		extensions = {
			@ExtensionDoc(name = "SECURITY_PRIVILEGE", content = "不需要鉴权")
		}
	)
	@ThriftMethod
	BizStrategyDataRespDTO findBizDataSet(BizDataFindReqDTO bizDataFindReqDTO) throws Exception;
}
