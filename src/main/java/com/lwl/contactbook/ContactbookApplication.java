package com.lwl.contactbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class ContactbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactbookApplication.class, args);
	}
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.lwl.contactbook")).build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Contact Book API")
				.description("Spring Boot REST API for CRUD Operations").version("1.0.0").build();
	}

}
