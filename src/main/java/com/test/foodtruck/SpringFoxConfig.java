package com.test.foodtruck;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("Food Trucks Locator API",
                "This is a web application that returns a list of 5 restaurants for a given latitude and altitude ",
                "1.0", "", new Contact("Pablo Mella", "", "pablo.mella.r@gmail.com"), "", "",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage( "com.test.foodtruck" ) )
                .paths(PathSelectors.any()).build();
    }

}
