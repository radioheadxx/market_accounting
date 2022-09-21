package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Warehouses;

import java.util.List;

public interface WarehousesService {
    Warehouses createWarehouses(Warehouses warehouses);

    List<Warehouses> getAllWarehouses();

    Warehouses updateWarehouses(Long id, Warehouses warehouses);

    Warehouses getWarehouses(long id);

    void deleteWarehouses(Long id);
}