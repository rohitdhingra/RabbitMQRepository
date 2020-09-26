package com.example.rabbitmq.demo.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.rabbitmq.demo.config.MessagingConfig;
import com.example.rabbitmq.demo.dto.OrderStatusDTO;

@Component
public class User {

	@RabbitListener(queues = MessagingConfig.JMD_QUEUE)
	public void consumeMessageFromQueue(OrderStatusDTO orderStatus)
	{
		System.out.println("Message received from queue: "+orderStatus);
	}
}
