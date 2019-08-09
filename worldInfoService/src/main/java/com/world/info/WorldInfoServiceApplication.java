package com.world.info;

import java.util.Collections;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.world.info.model.City;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@RestController
@MappedTypes(City.class)
@MapperScan("com.world.info.mapper")
@EnableSwagger2
@EnableEurekaClient
public class WorldInfoServiceApplication {
	
	/*
	 * @RequestMapping("/hi") public String sayHi() {
	 * 
	 * //cityService.getAllCities(); return "Hello World.....";
	 * 
	 * 
	 * }
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WorldInfoServiceApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
        app.run(args);
	}
	
	@Bean
	public Docket swaggerConfigaration() {
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.paths(PathSelectors.any())
		.apis(RequestHandlerSelectors.basePackage("com.world.info"))
		.build().apiInfo(getApiInfo());
	}
	

	private ApiInfo getApiInfo() {
		/*
		 * return new ApiInfo("City Service Api",
		 * "It Provides City details with help of Api", "2.0", "free to use",
		 * "Praveen Reddy", "API Liacance", "Perficient.com");
		 */
		
		Contact contact = new Contact("Praveen Reddy", "https://github.com/praveen", "praveenreddy.somu@gmail.com");
	    return new ApiInfoBuilder()
	            .title("City Service Info API")
	            .description(" It provide cities information service in all over world")
	            .contact(contact)
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .version("2.0.0")
	            .build();
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
