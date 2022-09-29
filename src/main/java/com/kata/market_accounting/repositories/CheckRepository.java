package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.Check;
import com.kata.market_accounting.models.Contractor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckRepository extends JpaRepository<Check, Long> {
}
