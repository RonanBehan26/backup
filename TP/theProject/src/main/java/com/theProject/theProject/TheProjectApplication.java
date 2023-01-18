package com.theProject.theProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TheProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheProjectApplication.class, args);
	}

	//we need to call other MS, therefore we need a RestTemplate
	@Bean
	@LoadBalanced //if multiple services connected to the service registry, then it will load balance
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
