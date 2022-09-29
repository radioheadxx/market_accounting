package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.models.Warehouses;
import com.kata.market_accounting.repositories.CurrencyRepository;
import com.kata.market_accounting.repositories.WarehousesRepository;
import com.kata.market_accounting.services.CurrencyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WarehousesServiceImplTest {
    @Mock
    private WarehousesRepository warehousesRepository;

    @InjectMocks
    private WarehousesServiceImpl warehousesService;

    private Warehouses warehouses;

    @BeforeEach
    public void setup() {
        warehousesRepository = Mockito.mock(WarehousesRepository.class);
        warehousesService = new WarehousesServiceImpl(warehousesRepository);
        warehouses = new Warehouses("test.wareh1", "Test Warehouses One", "TST1");
        warehouses.setId(1L);
    }

    @DisplayName("JUnit test for add warehouses method")
    @Test
    public void givenWarehousesObject_whenSaveWarehouses_thenReturnWarehousesObject() {

        given(warehousesRepository.save(warehouses)).willReturn(warehouses);

        System.out.println(warehousesRepository);
        System.out.println(warehousesService);

        Warehouses savedWarehouses = warehousesService.createWarehouses(warehouses);

        System.out.println(savedWarehouses);

        assertThat(savedWarehouses).isNotNull();
    }

    @DisplayName("JUnit test for getAll method")
    @Test
    public void givenWarehousesList_whenGetAllWarehouses_thenReturnWarehousesList() {
        Warehouses warehouses1 = new Warehouses("test.wareh2", "Test Warehoyses Two", "TST2");

        given(warehousesRepository.findAll()).willReturn(List.of(warehouses, warehouses1));

        List<Warehouses> warehousesList = warehousesService.getAllWarehouses();

        assertThat(warehousesList).isNotNull();
        assertThat(warehousesList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getOneById method")
    @Test
    public void givenWarehousesId_whenGetOneById_thenReturnWarehousesObject() {
        given(warehousesRepository.findById(1L)).willReturn(Optional.of(warehouses));

        Warehouses savedWarehouses = warehousesService.getWarehouses(warehouses.getId());

        assertThat(savedWarehouses).isNotNull();
    }

    @DisplayName("JUnit test for update method")
    @Test
    public void givenWarehousesObject_whenUpdateWarehouses_thenReturnUpdatedWarehouses() {
        given(warehousesRepository.save(warehouses)).willReturn(warehouses);
        warehouses.setName("Kata");

        Warehouses updatedWarehouse = warehousesService.updateWarehouses(warehouses);

        assertThat(updatedWarehouse.getName()).isEqualTo("Kata");
    }

    @DisplayName("JUnit test for delete method")
    @Test
    public void givenWarehousesId_whenDeleteWarehouses_ThenNothing() {
        long warehousesId = 1L;

        willDoNothing().given(warehousesRepository).deleteById(warehousesId);

        warehousesService.deleteWarehouses(warehousesId);

        verify(warehousesRepository, times(1)).deleteById(warehousesId);
    }
}