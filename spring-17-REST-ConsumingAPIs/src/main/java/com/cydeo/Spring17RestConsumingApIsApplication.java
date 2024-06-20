package com.cydeo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients // whatever in the project, we are consuming API through feintClient in that project we need to put this annotation
public class Spring17RestConsumingApIsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring17RestConsumingApIsApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	// I need to certain methods different classes, I need to inject this one,
	// but I need to create first @Bean and I can not @Component because class is not mine
	// if the class is not yours but if you need bean from this,
	// we can just create it in the Runner class

	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
