package com.example.demo.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {

	@Bean
	OpenAPI customOpenApi() {
		
		var openAPI = new OpenAPI()
				.components(new Components())
				.info(new Info()
				.title("API Contato - Sistema de teste")
				.version("0.1"));
				
		return openAPI;
	}
	
}