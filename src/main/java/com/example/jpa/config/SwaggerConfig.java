package com.example.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket apit(){
        // Docket : Swagger 설정의 핵심이 되는 Bean
        return new Docket(DocumentationType.SWAGGER_2).select()
                // apis : api 스펙이 작성되어 있는 패키지 지정
                .apis(RequestHandlerSelectors.basePackage("com.example.jpa.Controller"))
                // paths : apis에 있는 API중 특정 API를 선택
                .paths(PathSelectors.any())
                .build();
    }
}