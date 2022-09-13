package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.Warehouses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousesRepository extends JpaRepository<Warehouses, Long> {
}
