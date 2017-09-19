package com.springboot.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Conusmer2 {
	@JmsListener(destination = "sample.queue")
	@SendTo("out.queue") //把收到的消息转发到另一个队列里面
	public String receiveQueue(String text) {
		System.out.println("Consumer2收到的报文为:" + text);
		return "reverse message" + text;
	}
}
