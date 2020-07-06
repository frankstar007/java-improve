package com.dianping.overseas.data.data;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class CatRequest {

	/**
	 * 向目的URL发送post请求
	 * @param url       目的url
	 * @param params    发送的参数
	 * @return  ResultVO
	 */
	private static final String URL = "http://cat.vip.sankuai.com/cat/r/q?";


	public static String sendPostRequest(MultiValueMap<String, String> params) {
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpMethod method = HttpMethod.POST;
		// 以表单的方式提交
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//将请求头部和参数合成一个请求
		//发送post请求 附带token
		params.add("token", "89e99522c99748a69e1727c620545b4b");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
		//执行HTTP请求，将返回的结构使用ResultVO类格式化
		ResponseEntity response = client
			.exchange(URL, method, requestEntity, String.class);
		if (response.getBody() == null) return null;
		return response.getBody().toString();
	}

}
