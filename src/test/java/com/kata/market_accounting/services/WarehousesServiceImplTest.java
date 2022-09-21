package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.models.Warehouses;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class WarehousesServiceImplTest {
    @Autowired
    private WarehousesServiceImpl warehousesService;


    @Test
    void save() {
        Warehouses savedWarehouses = warehousesService.createWarehouses(new Warehouses(1L, "KATA", 14L,"Pushkin_street",true));
        assertThat(savedWarehouses.getId()).isGreaterThan(0);
        System.out.println(savedWarehouses);
    }

    @Test
    void getAllWarehouses() {
        List<Warehouses> warehouses = warehousesService.getAllWarehouses();
        assertThat(warehouses).size().isGreaterThan(0);
    }

    @Test
    void updateWarehouses() {
        Warehouses warehouses = new Warehouses(2L, "KATA", 15L,"Pushkin_street",true);
        warehouses.setCod(24L);
        warehousesService.createWarehouses(warehouses);
        warehousesService.updateWarehouses(1L, warehouses);

        assertThat(warehouses.getCod()).isEqualTo(24L);
        System.out.println(warehouses);
    }

    @Test
    void deleteWarehouses() {
        Warehouses warehouses = new Warehouses(2L, "KATA", 15L,"Pushkin_street",true);
        warehousesService.createWarehouses(warehouses);
        warehousesService.deleteWarehouses(2L);
        Warehouses deletedWarehouses = warehousesService.getWarehouses(2L);
        assertThat(deletedWarehouses).isNull();
    }
}