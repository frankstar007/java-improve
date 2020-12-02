package com.frankstar.mtdp.request;

import com.dianping.overseas.product.api.adapter.request.MtPoseidonDealRequest;
import com.dianping.overseas.product.api.adapter.request.SpecialExperienceRequest;

/**
 * @Author :  frankstar
 * @AddTime :  2020/11/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class TestRequest {


	public static void main(String[] args) {
		MtPoseidonDealRequest request = new MtPoseidonDealRequest();
		request.setPoiid(2332);
		request.setShopuuid("ssas");

		SpecialExperienceRequest specialExperienceRequest = new SpecialExperienceRequest();
		specialExperienceRequest.setShopid(3232);
		specialExperienceRequest.setShopuuid("dssd");

		System.out.println();
	}

}
