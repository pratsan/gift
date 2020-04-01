package com.star.gift;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
public class GiftApplication {
	@Bean
	SimpleMailMessage simpleMailMessage()
	{
		return new SimpleMailMessage();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GiftApplication.class, args);
	
	}

}
