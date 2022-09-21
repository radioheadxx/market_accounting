package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Warehouses;
import com.kata.market_accounting.repositories.WarehousesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class WarehousesServiceImpl implements WarehousesService{

    private final WarehousesRepository  warehousesRepository;

    public WarehousesServiceImpl(WarehousesRepository warehousesRepository) {
        this.warehousesRepository = warehousesRepository;
    }

    @Override
    public Warehouses getWarehouses(long id) {
        return warehousesRepository.findById(id).get();
    }

    @Override
    public Warehouses createWarehouses(Warehouses warehouses) {
       return warehousesRepository.save(warehouses);
    }

    @Override
    public List<Warehouses> getAllWarehouses() {
        return warehousesRepository.findAll();
    }
    @Override
    public Warehouses updateWarehouses(Long id, Warehouses warehouses) {
        Warehouses dbWarehouses = warehousesRepository.findById(id).get();
        dbWarehouses.setName(warehouses.getName());
        dbWarehouses.setCod(warehouses.getCod());
        dbWarehouses.setAddress(warehouses.getAddress());
        dbWarehouses.setAccess(warehouses.getAccess());
        warehousesRepository.flush();
        return dbWarehouses;
    }

    @Override
    public void deleteWarehouses(Long id) {
        warehousesRepository.deleteById(id);
    }
}
