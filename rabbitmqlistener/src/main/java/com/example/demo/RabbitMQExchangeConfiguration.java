package com.example.demo;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

	@Bean
	Exchange exampleExchange()
	{
		return new TopicExchange("ExampleExchange");
	}
	
	@Bean
	Exchange example2ndExchange()
	{
		return ExchangeBuilder.directExchange("example2ndExchange")
				.autoDelete()
				.internal()
				.build();
	}
	
	@Bean
	Exchange newExchange()
	{
		return ExchangeBuilder.topicExchange("TopicTestExchange")
				.autoDelete()
				.durable(true)
				.internal()
				.build();
	}
	
	
	@Bean
	Exchange fanOutExchange()
	{
		return ExchangeBuilder.fanoutExchange("fanOutExchange")
				.autoDelete()
				.internal()
				.durable(false)
				.build();
	}
	
	@Bean
	Exchange headersExchange()
	{
		return ExchangeBuilder.headersExchange("headersExchange")
				.autoDelete()
				.durable(true)
				.ignoreDeclarationExceptions()
				.build();
	}
}
