package com.frankstar.java.design.patterns.pubsub;

import java.util.Date;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class PlayingGameListener {

	public PlayingGameListener()
	{
		System.out.println("playing");
	}

	public void stopPlayingGame(Date date)
	{
		System.out.println("stop playing" + date);
	}
}
