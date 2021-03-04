package com.sankuai.grocery.product.udc.client.web;

import com.meituan.servicecatalog.api.annotations.FieldDoc;
import com.meituan.servicecatalog.api.annotations.Requiredness;
import com.meituan.servicecatalog.api.annotations.TypeDoc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Author :  frankstar
 * @AddTime :  2020/11/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
@ToString
@TypeDoc(
	description = "类目展示对象"
)
@ApiModel(description = "类目展示对象")
public class UDCTagVO {
	/**
	 * udc标签id,主键
	 */
	@FieldDoc(
		description = "标签ID",
		example = {"1"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private Long id;

	/**
	 * 标签名称
	 */
	@FieldDoc(
		description = "标签名称",
		example = {"UDC类目"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String tagName;

	/**
	 * 标签主体
	 */
	@FieldDoc(
		description = "标签主体",
		example = {"1"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String tagSubject;

	/**
	 * 标签描述
	 */
	@FieldDoc(
		description = "标签描述",
		example = {"udc标签适用于"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String tagDesc;


	/**
	 * 更新时间
	 */
	@FieldDoc(
		description = "更新时间",
		example = {"2020.11.20-12:00:00"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String updateTime;

	/**
	 * 操作者
	 */
	@FieldDoc(
		description = "操作者",
		example = {"frankstar"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String operator;

}