package com.kata.market_accounting;

import com.kata.market_accounting.models.Unit;
import com.kata.market_accounting.repositories.UnitRepository;
import com.kata.market_accounting.services.UnitServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UnitServiceTest {
    @Mock
    private static UnitRepository unitRepository;

    @InjectMocks
    UnitServiceImpl unitService;

    private Unit unit;

    @BeforeEach
    public void setup() {
        unitRepository = Mockito.mock(UnitRepository.class);
        unitService = new UnitServiceImpl(unitRepository);
        unit = new Unit(12L, "centimeter", "cm", 777);
    }

    @Test
    public void should_create_one_unit() {
        when(unitRepository.save(unit)).thenReturn(unit);
        assertThat(unitService.saveUnit(unit)).isNotNull();
    }

    @Test
    public void should_update_unit() {
        when(unitRepository.save(unit)).thenReturn(unit);
        unit.setShortName("cmt");
        Unit updatedUnit = unitService.updateUnit(unit);
        assertThat(updatedUnit.getShortName()).isEqualTo("cmt");
    }

    @Test
    public void should_get_list_of_units() {
        when(unitRepository.findAll()).thenReturn(Arrays.asList(unit));
        assertThat(unitService.getAllUnits().size()).isEqualTo(1);
    }

    @Test
    public void should_get_one_unit() {
        when(unitRepository.findById(12L)).thenReturn(Optional.of(unit));
        assertThat(unitService.getUnitById(12L)).isNotNull();
    }

    @Test
    public void should_delete_one_unit() {
        doNothing().when(unitRepository).deleteById(12L);
        when(unitRepository.findById(12L)).thenReturn(Optional.of(unit));
        unitService.deleteUnit(12L);
        verify(unitRepository).deleteById(12L);
    }
}
