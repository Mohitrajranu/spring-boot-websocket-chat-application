package com.javainuse.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javainuse.controller.RabbitMQMessageListener;

@Configuration
public class RabbitMQConfig {

	private static final String MY_QUEUE= "MyQueue";
	@Bean
	Queue myQueue(){
		return new Queue(MY_QUEUE,true);
	}
	@Bean
	Exchange myExchange(){
		return ExchangeBuilder.topicExchange("MyTopicExchange").durable(true).build();
	}
	/*@Bean
	Queue example2ndQueue(){
		return QueueBuilder.durable("ExampleQueue").autoDelete().exclusive().build();
	}
	*/
	@Bean
	Binding binding(){
		//return new Binding(MY_QUEUE,Binding.DestinationType.QUEUE,"MyTopicExchange","topic",null);
		return BindingBuilder.bind(myQueue()).to(myExchange()).with("topic").noargs();
	}
	
	
	@Bean
	ConnectionFactory connectionFactory(){
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}
	@Bean
	MessageListenerContainer messageListenerContainer(){
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(myQueue());
		simpleMessageListenerContainer.setMessageListener(new RabbitMQMessageListener());
		return simpleMessageListenerContainer;
		
	}
}
