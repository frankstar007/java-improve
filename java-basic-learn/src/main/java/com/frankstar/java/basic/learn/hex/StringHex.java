package com.frankstar.java.basic.learn.hex;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class StringHex {


	String hex = "E9A284E594AEE8B49DE78EB2E7BE8EE9BB84E98791E8B4B5E5A687E5A5A2E5AEA0E4B99DE4BBB6E5A597EFBC88E9BB84E98791E79A99E9A29CE6B481E99DA2E4B9B331303067E38081E9BB84E98791E79A99E9A29CE69F94E882A4E6B0B43132306D6CE38081E9BB84E98791E79A99E9A29CE7BE8EE882A4E4B9B33132306D6CE38081E9BB84E98791E5A5A2E5AEA0E6BB8BE6B6A6E99C9C353067E38081E9BB84E98791E5A5A2E5AEA0E4BFAEE68AA4E7B2BEE58D8EE6B6B231356D6C2A33E793B6E38081E8B49DE78EB2E7BE8EE786ACE5A49CE7B4A7E887B4E98791E79CBCE99C9C363067E38081E8B49DE78EB2E7BE8EE9BB84E98791E89B8BE799BDE8B4B5E5A687E8868F313067EFBC892FE5A597E79B92";

	public static void main(String[] args) {
		String name = "荔浦芋头 500g/份";
		System.out.println(StringToHex(name));
	}

	private static final char[] digital = new char[]
		{'0','1','2','3', '4','5','6','7','8',
			'9','A','B','C','D','E','F'};

	public static String StringToHex(String str) {
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(digital[bit]);
			bit = bs[i] & 0x0f;
			sb.append(digital[bit]);
		}
		return sb.toString();
	}


	public static String hexToString(String hex) {
		return "";
	}

}
