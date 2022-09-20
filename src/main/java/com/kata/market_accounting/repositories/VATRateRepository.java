package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.VATRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VATRateRepository extends JpaRepository<VATRate, Long> {
}
