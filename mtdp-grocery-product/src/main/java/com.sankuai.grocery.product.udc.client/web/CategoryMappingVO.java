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
	description = "类目映射关系展示对象"
)
@ApiModel(description = "类目映射关系展示对象")
public class CategoryMappingVO {

	/**
	 * 映射id,主键
	 */
	@FieldDoc(
		description = "标签ID 可以为null 单纯筛选时 有可能为null",
		example = {"1"},
		requiredness = Requiredness.OPTIONAL
	)
	@ApiModelProperty(required = true)
	private Long id;


	/**
	 * udc类目id,唯一键
	 */
	@FieldDoc(
		description = "udc类目id,唯一键",
		example = {"1"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private Long udcNodeId;

	/**
	 * udc类目名称
	 */
	@FieldDoc(
		description = "udc类目名称",
		example = {"UDC类目"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String udcNodeName;


	/**
	 * udc类目路径
	 */
	@FieldDoc(
		description = "udc类目路径",
		example = {"UDC类目"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String udcNodePath;

	/**
	 * 优选类目id
	 */
	@FieldDoc(
		description = "优选类目id, 可能为空",
		example = {"1"},
		requiredness = Requiredness.OPTIONAL
	)
	@ApiModelProperty(required = true)
	private Long preferredNodeId;


	/**
	 * 优选类目名称
	 */
	@FieldDoc(
		description = "优选类目名称, 可能为空",
		example = {"1"},
		requiredness = Requiredness.OPTIONAL
	)
	@ApiModelProperty(required = true)
	private String preferredNodeName;


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
	 * 操作人
	 */
	@FieldDoc(
		description = "操作人",
		example = {"2020.11.20-12:00:00"},
		requiredness = Requiredness.REQUIRED
	)
	@ApiModelProperty(required = true)
	private String operator;

}
