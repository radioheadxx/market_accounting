package com.kata.market_accounting;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@EnableWebMvc
@SpringBootApplication
public class MarketAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketAccountingApplication.class, args);
    }
}
