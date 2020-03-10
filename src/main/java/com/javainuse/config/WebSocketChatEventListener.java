package com.javainuse.config;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.javainuse.domain.SimpleMessage;
import com.javainuse.domain.WebSocketChatMessage;

@Component
public class WebSocketChatEventListener {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        System.out.println("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {

            WebSocketChatMessage chatMessage = new WebSocketChatMessage();
            chatMessage.setType("Leave");
            chatMessage.setSender(username);

            messagingTemplate.convertAndSend("/topic/javainuse", chatMessage);
            SimpleMessage simpleMessage = new SimpleMessage();
            simpleMessage.setName("FirstMessage");
            simpleMessage.setDescription("simpleDescription");
            rabbitTemplate.convertAndSend("TestExchange","testRouting",simpleMessage);
           // rabbitTemplate.convertAndSend("TestExchange","testRouting","Hello From Code");
        }
    }
}
