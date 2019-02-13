package com.frankstar.july.mode.observermode;

/**
 * Author    :  frankstar
 * AddTime   :  2017/8/3
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public interface Observer {

    /**
     * update state
     */

    public void update(String state);
}
