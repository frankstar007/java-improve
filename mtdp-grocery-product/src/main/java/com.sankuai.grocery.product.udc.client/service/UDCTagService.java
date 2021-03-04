package com.sankuai.grocery.product.udc.client.service;

import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import com.meituan.servicecatalog.api.annotations.ExtensionDoc;
import com.meituan.servicecatalog.api.annotations.InterfaceDoc;
import com.meituan.servicecatalog.api.annotations.MethodDoc;
import com.sankuai.grocery.product.udc.client.response.GetAllTagTResponse;
import org.apache.thrift.TException;

/**
 * @Author :  frankstar
 * @AddTime :  2020/11/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@InterfaceDoc(
	type = "thrift",
	scenarios = "udc标签管理,包括增删改查，移动等等",
	description = "udc标签的增删改查"
)
@ThriftService
public interface UDCTagService {

	@MethodDoc(
		name = "getAllCategoryTService",
		description = "获取所有TagNode",
		displayName = "获取所有TagNode thrift接口",
		returnValueDescription = "返回tag列表",
		restExampleResponseData = "{\n" +
			"\"code\": 0,\n" +
			"\"msg\": \"test msg\",\n" +
			"\"data\": []\n" +
			"}",
		extensions = {
			@ExtensionDoc(name = "SECURITY_PRIVILEGE", content = "不需要鉴权")
		}
	)
	@ThriftMethod
	GetAllTagTResponse getAllTags() throws TException;
}