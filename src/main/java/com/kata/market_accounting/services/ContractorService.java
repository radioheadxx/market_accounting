package com.kata.market_accounting.services;


import com.kata.market_accounting.models.Contractor;
import com.kata.market_accounting.models.ContractorStatus;

import java.util.List;

public interface ContractorService {
    Contractor create(Contractor contractor);
    List<Contractor> getAll();
    Contractor getOneById(long id);
    Contractor update(Contractor contractor);
    void delete(Long id);
}
