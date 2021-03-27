package com.sankuai.grocery.product.udc.client.response;

import com.facebook.swift.codec.ThriftField;
import com.sankuai.grocery.product.udc.client.common.TCommonResponse;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class GetBizDataResponse extends TCommonResponse {


	private int bizCode;

	@ThriftField(3)
	private List<Object> bizDataList;

}
