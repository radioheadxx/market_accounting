package com.kata.market_accounting.init;

import com.kata.market_accounting.models.VATRate;
import com.kata.market_accounting.repositories.VATRateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class InitVATRate implements CommandLineRunner {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");

    private VATRateRepository repository;

    public InitVATRate(VATRateRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        VATRate rate1 = new VATRate();
        VATRate rate2 = new VATRate();
        VATRate rate3 = new VATRate();
        VATRate rate4 = new VATRate();

        rate1.setType("Системный");
        rate1.setRate(0);
        rate1.setGeneralAccess(false);
        rate1.setDateAndTime(LocalDateTime.now().format(formatter));

        rate2.setType("Системный");
        rate2.setRate(10);
        rate2.setGeneralAccess(false);
        rate2.setDateAndTime(LocalDateTime.now().format(formatter));

        rate3.setType("Системный");
        rate3.setRate(18);
        rate3.setGeneralAccess(false);
        rate3.setDateAndTime(LocalDateTime.now().format(formatter));

        rate4.setType("Системный");
        rate4.setRate(20);
        rate4.setGeneralAccess(false);
        rate4.setDateAndTime(LocalDateTime.now().format(formatter));

        repository.save(rate1);
        repository.save(rate2);
        repository.save(rate3);
        repository.save(rate4);
    }
}
