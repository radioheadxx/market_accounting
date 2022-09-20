package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> getCountries();

    Country save(Country country);

    void delete(long id);

    void update(long id, Country country);

    Country getCountry(long id);

}
