package com.kata.market_accounting.service;

import com.kata.market_accounting.models.Projects;
import com.kata.market_accounting.repositories.CountryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Projects> findAll() {
        return countryRepository.findAll();
    }

    @Transactional
    @Override
    public void save(Projects projects) {
        countryRepository.save(projects);
    }

    @Transactional
    @Override
    public void update(Projects projects) {
        countryRepository.save(projects);
    }

    @Transactional
    @Override
    public void delete(Projects projects) {
        countryRepository.delete(projects);
    }
}

