package com.sankuai.grocery.product.udc.client.response;

import com.facebook.swift.codec.ThriftField;
import com.facebook.swift.codec.ThriftStruct;
import com.meituan.servicecatalog.api.annotations.FieldDoc;
import com.meituan.servicecatalog.api.annotations.TypeDoc;
import com.sankuai.grocery.product.udc.client.common.TCommonResponse;
import com.sankuai.grocery.product.udc.client.model.TagDTO;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/11/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@TypeDoc(
	description = "类目展示对象"
)
@ThriftStruct
public class GetAllTagTResponse extends TCommonResponse {

	@FieldDoc(
		description = "标签列表",
		rule = "List<TagDTO>"
	)
	private List<TagDTO> tagDTOList;

	@ThriftField(3)
	public List<TagDTO> getTagDTOList() {
		return tagDTOList;
	}

	@ThriftField
	public void setTagDTOList(List<TagDTO> tagDTOList) {
		this.tagDTOList = tagDTOList;
	}
}
