package com.sankuai.grocery.product.udc.client.model;

import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class BizDataFindReqDTO {

	private Integer entityId;
	private Integer attributeId;
	private String attributeName;
	private Integer mtShopId;
	private Integer accountId;
}
