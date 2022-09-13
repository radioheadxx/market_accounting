package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegalEntityRepository extends JpaRepository <LegalEntity, Long> {

}
