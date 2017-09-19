package com.springboot;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
    //这样就链接到安装的activemq,不是内嵌的。
	@Bean
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(
				ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD,
				// "tcp://192.168.0.100:61616");
				ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
		return activeMQConnectionFactory;
	}

	public static void main(String[] args) {

		SpringApplication.run(App.class, args);
	}

}
