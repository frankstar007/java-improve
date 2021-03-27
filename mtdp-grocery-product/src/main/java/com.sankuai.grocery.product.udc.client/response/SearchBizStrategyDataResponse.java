package com.sankuai.grocery.product.udc.client.response;

import com.meituan.servicecatalog.api.annotations.FieldDoc;
import com.sankuai.grocery.product.udc.client.common.TCommonResponse;
import com.sankuai.grocery.product.udc.client.model.BizStrategyDataDTO;
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
public class SearchBizStrategyDataResponse extends TCommonResponse{

	@FieldDoc(
		description = "业务策略数据列表"
	)
	private List<BizStrategyDataDTO> bizStrategyDataDTOS;

	/**
	 * 数据总量
	 */
	private int total;

}
