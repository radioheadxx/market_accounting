package com.kata.market_accounting.repositiries;

import com.kata.market_accounting.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Query("SELECT c FROM Currency c WHERE c.shortName = ?1")
    Currency findByShortName(String shortName);
}
