package com.esliceu.demospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemospringApplication implements WebMvcConfigurer {
	@Autowired
	com.esliceu.demospring.interceptors.LoginInterceptor loginInterceptor;

	public static void main(String[] args) {
		SpringApplication.run(DemospringApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor).addPathPatterns("/private");
	}
}
