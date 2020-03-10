package com.javainuse.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfiguration {

	@Bean
	Exchange exampleExchange(){
		return new TopicExchange("ExampleExchange");
	}
	@Bean
	Exchange example2ndExchange(){
		return ExchangeBuilder.directExchange("Example2Exchange").autoDelete().internal().build();
	}
	@Bean
	Exchange topicExchange(){
		return ExchangeBuilder.topicExchange("TopicExchange").autoDelete().durable(true).internal().build();
	}
	@Bean
	Exchange fanoutExchange(){
		return ExchangeBuilder.directExchange("FanOutExchange").autoDelete().durable(false).internal().build();
	}
	@Bean
	Exchange headersExchange(){
		return ExchangeBuilder.headersExchange("HeadersExchange").autoDelete().durable(false).ignoreDeclarationExceptions().build();
	}
}
