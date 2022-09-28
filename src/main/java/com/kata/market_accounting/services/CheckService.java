package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Check;

import java.util.List;

public interface CheckService {
    Check create(Check check);

    List<Check> getAll();

    Check getOneById(long id);

    Check update(Check check);

    void delete(Long id);
}
