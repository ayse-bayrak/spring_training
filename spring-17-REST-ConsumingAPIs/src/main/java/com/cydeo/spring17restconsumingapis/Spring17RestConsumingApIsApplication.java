package com.cydeo.spring17restconsumingapis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class Spring17RestConsumingApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring17RestConsumingApIsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	// I need to certain methods different classes, i need to inject this one,
	// but i need to cretae firt @Bean and I can not @Component bevause class is not mine
	// if the class is not yours but if you need bean from this,
	// we can just create it in the Runner class

}
