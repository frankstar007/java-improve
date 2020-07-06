package com.dianping.overseas.data.service;

import com.dianping.overseas.poseidon.common.Response;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 指标数据
 */
public interface TagDataService {


	/**
	 * 获取某个指标数据
	 * @param tagId
	 * @return
	 */
	Response loadTagData(String tagId);


	/**
	 * 获取某些指标数据
	 * @param tagId
	 * @return
	 */
	Response loadTagsData(List<String> tagId);


	/**
	 * 存储指标数据
	 * @param tagId
	 * @return
	 */
	Response saveTagData(String tagId);



	/**
	 * 存储指标数据
	 * @param tagIds
	 * @return
	 */
	Response batchSave(List<String> tagIds);

}
