package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCurrencies();

    void save(Country country);

    void delete(Country country);

    void update(long id, Country country);

}
