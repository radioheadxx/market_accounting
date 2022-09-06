package com.kata.market_accounting.service;

import com.kata.market_accounting.models.Projects;

import java.util.List;

public interface CountryService {

    List<Projects> findAll();

    void save(Projects projects);

    void delete(Projects projects);

    void update(Projects projects);

}
