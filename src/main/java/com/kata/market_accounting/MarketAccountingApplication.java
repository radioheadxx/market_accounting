package com.kata.market_accounting;

import com.kata.market_accounting.models.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableWebMvc
@SpringBootApplication
public class MarketAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketAccountingApplication.class, args);


    }

}
