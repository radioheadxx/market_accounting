package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.ContractorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractorStatusRepository extends JpaRepository<ContractorStatus, Long> {
}
