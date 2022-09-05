package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;

import java.util.List;

public interface CurrencyService {
    public void create(Currency currency);
    public List<Currency> getAll();
    public Currency getOneById(long id);
    public void update(Currency currency);
    public void delete(Long id);
}
