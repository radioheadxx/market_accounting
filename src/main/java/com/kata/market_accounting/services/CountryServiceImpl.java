package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class CountryServiceImpl implements CountryService {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountry(long id) {
        Country country = null;
        Optional<Country> optional = countryRepository.findById(id);
        if (optional.isPresent()) {
            country = optional.get();
        }
        return country;
    }

    @Override
    public Country save(Country country) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        country.setDate(formattedDateTime);
        countryRepository.save(country);
        return country;
    }

    @Override
    public void update(long id, Country country) {
        Country dbcountry = countryRepository.findById(id).get();
        dbcountry.setShortName(country.getShortName());
        dbcountry.setFullName(country.getFullName());
        dbcountry.setDigitalCode(country.getDigitalCode());
        dbcountry.setLetterCode1(country.getLetterCode1());
        dbcountry.setLetterCode2(country.getLetterCode2());

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(dtf);
        dbcountry.setDate(formattedDateTime);

        countryRepository.flush();
    }

    @Override
    public void delete(long id) {
        countryRepository.deleteById(id);
    }
}

