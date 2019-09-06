package com.javainuse.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import com.javainuse.domain.WebSocketChatMessage;

@Controller
public class WebSocketChatController {
/*
	@RequestMapping("/helloworld")
	 public ModelAndView hello(ModelAndView modelAndView) {
	 
	  String helloWorldMessage = "Hello world from java2blog!";
	  modelAndView.addObject("resetToken", "Mohit");
	  modelAndView.addObject("message", helloWorldMessage);
	  modelAndView.setViewName("hello");
	  return modelAndView;
	 }*/
	
	@MessageMapping("/chat.sendMessage")
	@SendTo("/topic/javainuse")
	public WebSocketChatMessage sendMessage(@Payload WebSocketChatMessage webSocketChatMessage) {
		return webSocketChatMessage;
	}

	@MessageMapping("/chat.newUser")
	@SendTo("/topic/javainuse")
	public WebSocketChatMessage addUser(@Payload WebSocketChatMessage webSocketChatMessage,
			SimpMessageHeaderAccessor headerAccessor) {
		headerAccessor.getSessionAttributes().put("username", webSocketChatMessage.getSender());
		return webSocketChatMessage;
	}

}
