package com.kata.market_accounting.services;

import com.kata.market_accounting.models.ContractorStatus;

import java.util.List;

public interface ContractorStatusService {
    ContractorStatus create(ContractorStatus contractorStatus);

    List<ContractorStatus> getAll();

    ContractorStatus getOneById(long id);

    ContractorStatus update(ContractorStatus contractorStatus);

    void delete(Long id);
}
