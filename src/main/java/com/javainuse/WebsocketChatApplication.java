package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = {"com.javainuse.*"})
public class WebsocketChatApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebsocketChatApplication.class, args);
	}

    
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
    	return application.sources(WebsocketChatApplication.class);
    }
}
