package com.dianping.overseas.data.data;

import lombok.Builder;
import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
@Builder
public class CatData {

	private long time;

	private double count;
}
