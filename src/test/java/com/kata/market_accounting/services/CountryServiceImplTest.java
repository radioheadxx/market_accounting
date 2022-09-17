package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.repositories.CountryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CountryServiceImplTest {

    @Autowired
    private CountryService countryService;

    @Test
    void save() {
        Country savedCountry = countryService.save(new Country(1L, "Russia", "Russian Federation", (byte) 1, "RU", "RUS", true));
        assertThat(savedCountry.getId()).isGreaterThan(0);
        System.out.println(savedCountry);
    }

    @Test
    void getCurrencies() {
        List<Country> countries = countryService.getCountries();
        assertThat(countries).size().isGreaterThan(0);
    }

    @Test
    void update() {
        Country country1 = new Country(2L, "Germany", "Germany Republic", (byte) 2, "GE", "GER", true);
        country1.setDigitalCode((byte) 24);
        countryService.save(country1);
        countryService.update(1, country1);

        assertThat(country1.getDigitalCode()).isEqualTo((byte) 24);
        System.out.println(country1);

    }

    @Test
    void delete() {
        Country country1 = new Country(2L, "France", "France Republic", (byte) 2, "FR", "FRA", true);
        countryService.save(country1);
        countryService.delete(2L);
        Country deletedCountry = countryService.getCountry(2L);
        assertThat(deletedCountry).isNull();
    }
}