package com.ge.knowledge.session.config;


import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class AppConfig {

    @Bean
    @Profile("swagger")
    public Docket connectorApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfo(
                "Knowledge sharing planning",
                "Knowledge sharing planning"
                , "1.0", null, "knowledge", null, null))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ge.knowledge.session.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class,
                        String.class)
                .genericModelSubstitutes(ResponseEntity.class)

                .useDefaultResponseMessages(false);
    }
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }
}
