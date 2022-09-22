package com.kata.market_accounting.init;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class InitCountry implements ApplicationRunner {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final CountryRepository countryRepository;

    @Autowired
    public InitCountry(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void run(ApplicationArguments args) {
        Country country = new Country();
        country.setId(1L);
        country.setShortName("Russia");
        country.setFullName("Russian Federation");
        country.setDigitalCode((byte) 2);
        country.setLetterCode1("RU");
        country.setLetterCode2("RUS");
        country.setAccess(false);
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        country.setDate(formattedDateTime);;
        countryRepository.save(country);
    }
}

