package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;
import com.kata.market_accounting.repositories.CountryRepository;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CountryServiceImplTest {

    private Country country;
    @Mock
    CountryRepository countryRepository;
    @Autowired
    private CountryService countryService;

    @BeforeEach
    public void completion() {
        country = new Country(3L,"Russia","Russian Federation", (byte) 1,"RU","RUS",true);
    }

    @Test
    void save() {
        Country saveCountry = countryService.save(country);
        System.out.println(saveCountry);
        assertThat(saveCountry).isNotNull();
        Assert.assertTrue(country.isAccess());
    }

    @Test
    void getCurrencies() {
        System.out.println(countryService.getCurrencies());
    }
    @Test
    void update() {
    }
//
//    @Test
//    void delete() {
//    }
}