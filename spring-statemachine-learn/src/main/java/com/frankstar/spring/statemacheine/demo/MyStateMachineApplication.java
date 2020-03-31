package com.frankstar.spring.statemacheine.demo;

import com.frankstar.spring.statemacheine.demo.enums.Events;
import com.frankstar.spring.statemacheine.demo.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @Author :  frankstar
 * @AddTime :  2020/2/26
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@SpringBootApplication
public class MyStateMachineApplication implements CommandLineRunner {


	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... strings) throws Exception {
		stateMachine.sendEvent(Events.E1);
		stateMachine.sendEvent(Events.E2);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyStateMachineApplication.class, args);
	}

}
