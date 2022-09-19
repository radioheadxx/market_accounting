package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Unit;
import java.util.List;

public interface UnitService {
    List<Unit> getAllUnits();
    Unit getUnitById(Long id);
    Unit saveUnit(Unit unit);
    Unit updateUnit(Unit unit);
    void deleteUnit(Long id);
}
