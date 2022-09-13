package com.kata.market_accounting;

import com.kata.market_accounting.models.Project;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableWebMvc
@SpringBootApplication
public class MarketAccountingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarketAccountingApplication.class, args);
    }
}
