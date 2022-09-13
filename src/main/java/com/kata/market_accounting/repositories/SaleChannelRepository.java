package com.kata.market_accounting.repositories;

import com.kata.market_accounting.models.SaleChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleChannelRepository extends JpaRepository<SaleChannel, Long> {

}
