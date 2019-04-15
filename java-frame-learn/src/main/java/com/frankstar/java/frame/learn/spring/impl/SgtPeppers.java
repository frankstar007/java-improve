package com.frankstar.java.frame.learn.spring.impl;

import com.frankstar.java.frame.learn.spring.service.CompactDisc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
@Component
public class SgtPeppers implements CompactDisc {

	private String title = "Sgt. Pepper's Disc";

	private String artist = "The Beatles";

	@Override
	public void play() {
		log.info("playing " + title + " by " + artist);
		System.out.println(
			"playing " + title + " by " + artist
		);
	}
}
