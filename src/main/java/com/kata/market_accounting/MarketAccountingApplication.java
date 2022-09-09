package com.kata.market_accounting;

import com.kata.market_accounting.models.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
public class MarketAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketAccountingApplication.class, args);
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.kata.market_accounting")).build();
    }
}
