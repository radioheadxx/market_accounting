package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Warehouses;

import java.util.List;

public interface WarehousesService {
    Warehouses createWarehouses(Warehouses usr);

    List<Warehouses> getAllWarehouses();

    Warehouses updateWarehouses(Warehouses usr);

    Warehouses getWarehouses(long id);

    void deleteWarehouses(Warehouses usr);

}