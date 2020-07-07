package com.dianping.overseas.data.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.xml.bind.DatatypeConverter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 构造天网请求
 */
public class RadarRequest {


	/**
	 * 向目的URL发送post请求
	 * @param url       目的url
	 * @param params    发送的参数
	 * @return  ResultVO
	 */
	private static final String URL = "https://tw.sankuai.com/api/metric?app_name=poseidon-order-service&_source=api";


	public static String sendPostRequest(MultiValueMap<String, String> params) {
		RestTemplate client = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpMethod method = HttpMethod.POST;
		// 以表单的方式提交
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		//将请求头部和参数合成一个请求
		//发送post请求 附带token
		//params.add("token", "75890b80cf9da08a727aa41ba31062cb");

		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
		//执行HTTP请求，将返回的结构使用ResultVO类格式化
		ResponseEntity response = client
			.exchange(URL, method, requestEntity, String.class);
		System.out.println(response);

		if (response.getBody() == null) return null;
		return response.getBody().toString();
	}


	public static void main(String[] args) throws NoSuchAlgorithmException {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		//params.add("id", "2189620");
		params.add("app_name", "poseidon-order-service");


		sendPostRequest(params);

		String appKey = "poseidon-order-service";
		String token = "75890b80cf9da08a727aa41ba31062cb";

		//String result = sendPostRequest(params);


		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		String requestDate = sdf.format(new Date());
		String stringToSign = String.format("%s %s %s", appKey, token, requestDate);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(stringToSign.getBytes());
		byte[] digest = md.digest();
		String signature = DatatypeConverter.printHexBinary(digest).toLowerCase();
		String authToken = String.format("%s:%s", appKey, signature);

		System.out.println(String.format("AUTH-TOKEN:\n%s, \nREQ-DATE:\n%s", authToken, requestDate));

		params.add("AUTH-TOKEN", authToken);
		params.add("REQ-DATE", requestDate);

		String result = sendPostRequest(params);

	}


	private String loadTokenDate(String appKey, String token) throws NoSuchAlgorithmException {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		String requestDate = sdf.format(new Date());
		String stringToSign = String.format("%s %s %s", appKey, token, requestDate);
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(stringToSign.getBytes());
		byte[] digest = md.digest();
		String signature = DatatypeConverter.printHexBinary(digest).toLowerCase();
		String authToken = String.format("%s:%s", appKey, signature);

		System.out.println(String.format("AUTH-TOKEN:\n%s, \nREQ-DATE:\n%s", authToken, requestDate));


		return "";
	}
}
