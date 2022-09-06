package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;

import java.util.List;

public interface CurrencyService {
    void create(Currency currency);

    List<Currency> getAll();

    Currency getOneById(long id);

    void update(Currency currency);

    void delete(Long id);
}
