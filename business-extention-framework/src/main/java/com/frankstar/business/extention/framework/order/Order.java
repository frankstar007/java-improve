package com.frankstar.business.extention.framework.order;

import com.dianping.twork.common.adaptable.PlatformObject;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class Order extends PlatformObject implements IOrder {

	private List<OrderItem> orderItems = new ArrayList<OrderItem>();

	private int number;

	private String type;

	private float price;

	private final Map<String, Object> attributes = Maps.newHashMap();

	@Override
	public Object getAdapter(Class adapter) {
		return null;
	}

	@Override
	public void addItem(DrinkType drinkType, int shots, boolean iced) {

	}

	@Override
	public List<OrderItem> getItems() {
		return null;
	}

	@Override
	public void putAttribute(String key, Object value) {

	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public Object getAttribute(String key) {
		return null;
	}
}
