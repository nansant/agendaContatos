package com.example.demo.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
	.allowedOrigins("http://localhost:4200")
	//permissão para o servidor do angular
	.allowedMethods("POST", "PUT", "DELETE", "GET")
	//métodos
	.allowedHeaders("*");

	}
}
