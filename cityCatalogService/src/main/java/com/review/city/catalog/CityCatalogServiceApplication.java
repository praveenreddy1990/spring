package com.review.city.catalog;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.review.city.catalog.model.CityCatalog;

@SpringBootApplication
@MappedTypes(CityCatalog.class)
@MapperScan("com.review.city.catalog.mapper")
@RestController
@EnableEurekaClient
public class CityCatalogServiceApplication {

	@RequestMapping("/hi")
	public String sayHello() {
		return "Hello World";
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CityCatalogServiceApplication.class, args);
	}

}
