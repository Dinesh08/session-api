package com.ge.knowledge.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages={"com.ge.knowledge.session"})
@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class})
@EnableSwagger2
@EnableAsync
@EnableScheduling
@EnableTransactionManagement
public class SessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}
	 /*@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurerAdapter() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/session").allowedOrigins("*");
	         }
	      };
	   }*/
}

