package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Transactional
@Service
public class CountryServiceImpl implements CountryService {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCurrencies() {
        return countryRepository.findAll();
    }

    @Override
    public void save(Country country) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        country.setDate(formattedDateTime);
        countryRepository.save(country);
    }

    @Override
    public void update(long id, Country country) {
        Country country1 = countryRepository.findById(id).get();
        country1.setShortName(country.getShortName());
        country1.setFullName(country.getFullName());
        country1.setDigitalCode(country.getDigitalCode());
        country1.setLetterCode1(country.getLetterCode1());
        country1.setLetterCode2(country.getLetterCode2());

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        country1.setDate(formattedDateTime);

        countryRepository.save(country);

        countryRepository.flush();
    }

    @Override
    public void delete(Country country) {
        countryRepository.delete(country);
    }
}

