package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
