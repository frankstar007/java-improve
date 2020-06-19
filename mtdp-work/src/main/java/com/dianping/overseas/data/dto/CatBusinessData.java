package com.dianping.overseas.data.dto;

import java.io.Serializable;
import java.util.Map;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public class CatBusinessData implements Serializable{

	private String id;

	private String title;

	private int viewOrder;

	private int code;

	private String metricType;

	private Map<String, Map<String, Integer>> datas;

	private Map<String, Object> metricTagChartConfig;

	private int indexOfSecondYAxis;

	private Map<String, Map<String, Integer>> statistics;

	private Map<String, Map<String, Object>> chartInfo;
}
