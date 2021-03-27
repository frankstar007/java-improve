package com.sankuai.grocery.product.udc.client.response;

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
public class BizStrategyDataRespDTO {

	private int bizCode;

	private Long strategyId;

	private List<BizStrategyDataDTO> bizStrategyDataDTOList;

}
