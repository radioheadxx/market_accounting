package com.kata.market_accounting.init;

import com.kata.market_accounting.models.Warehouses;
import com.kata.market_accounting.repositories.WarehousesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class InitWarehouses implements ApplicationRunner {
    private final WarehousesRepository warehousesRepository;

    @Autowired
    public InitWarehouses(WarehousesRepository warehousesRepository) {
        this.warehousesRepository = warehousesRepository;
    }

    public void run(ApplicationArguments args) {
        Warehouses warehouses = new Warehouses();

        warehouses.setId(1L);
        warehouses.setName("Kata");
        warehouses.setCod(2L);
        warehouses.setAddress("Pushkin_street");
        warehouses.setAccess(true);
        warehousesRepository.save(warehouses);
    }
}
