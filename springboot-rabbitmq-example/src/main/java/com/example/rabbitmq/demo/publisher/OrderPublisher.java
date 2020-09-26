package com.example.rabbitmq.demo.publisher;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.demo.config.MessagingConfig;
import com.example.rabbitmq.demo.dto.OrderDTO;
import com.example.rabbitmq.demo.dto.OrderStatusDTO;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

	@Autowired
	private RabbitTemplate template;
	
	@PostMapping("/{restaurantName}")
	public String bookOrder(@RequestBody OrderDTO orderDTO,@PathVariable String restaurantName)
	{
		orderDTO.setOrderId(UUID.randomUUID().toString());
		//restaurant service
		//payment service
		OrderStatusDTO orderStatus = new OrderStatusDTO(orderDTO,"PROCESS","Order Placed Successfully in "+restaurantName);
		template.convertAndSend(MessagingConfig.JMD_EXCHANGE, MessagingConfig.JMD_ROUTINGKEY, orderStatus);
		return "Success";
	}
}
