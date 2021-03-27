package com.sankuai.grocery.product.udc.client.model;

import java.util.List;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class BizStrategyDataDTO {

	private Long skuId;

	private int categoryId;

	private List<AttributeDTO> attributeDTOList;

}
