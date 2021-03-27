package com.sankuai.grocery.product.udc.client.response;

import com.meituan.servicecatalog.api.annotations.FieldDoc;
import com.meituan.servicecatalog.api.annotations.Requiredness;
import com.sankuai.grocery.product.udc.client.common.TPaging;
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
public class SearchBizStrategyDataRequest {


	/**
	 * 商品标签集合
	 */
	private List<Long> skuIds;

	/**
	 * 网店集合
	 */
	private List<Long> poiId;

	/**
	 * 品类集合
	 */
	private List<Long> categoryIds;

	/**
	 * 最小值
	 */
	private Double minPrice;

	/**
	 * 最大值
	 */
	private Double maxPrice;

	/**
	 * 坑位
	 */
	private int locatePosition;

	/**
	 * 档期状态
	 */
	private String appearDate;

	/**
	 * 商品标签
	 */
	private int skuTag;




	@FieldDoc(
		description = "分页条件",
		requiredness = Requiredness.REQUIRED
	)
	private TPaging page;
}
