package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Projects,Long> {
}