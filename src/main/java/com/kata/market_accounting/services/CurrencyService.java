package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;

import java.util.List;

public interface CurrencyService {
    Currency create(Currency currency);

    List<Currency> getAll();

    Currency getOneById(long id);

    Currency update(Currency currency);

    void delete(Long id);
}
