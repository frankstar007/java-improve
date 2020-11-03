package com.frankstar.business.extention.framework.order;

import com.dianping.twork.common.adaptable.IAdaptable;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public interface IOrder extends IAdaptable {

	public void addItem(DrinkType drinkType, int shots, boolean iced);

	public List<OrderItem> getItems();

	public void putAttribute(String key, Object value);

	public String getType();

	public Object getAttribute(String key);
}
