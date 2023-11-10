package com.emp.EmployeeDetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmployeeDetailsApplication02Dummy {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetailsApplication02Dummy.class, args);
	}
	
//	 @Bean
//	public WebMvcConfigurer corsConfigurer()
//	{
//		return new WebMvcConfigurer() {
//			public void addCorsMappings(CorsRegistry registry)
//			{
//				registry.addMapping("/**")
//				.allowedMethods("*")
//				.allowedOrigins("http://localhost:3000");
//			}
//		};
//		
//	}
	 

}