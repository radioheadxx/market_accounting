package com.kata.market_accounting.init;

import com.kata.market_accounting.models.Unit;
import com.kata.market_accounting.services.UnitService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitUnit implements ApplicationRunner {

    private final UnitService unitService;

    public InitUnit(UnitService unitService) {
        this.unitService = unitService;
    }

    @Override
    public void run(ApplicationArguments args){
        Unit unit = new Unit();

        unit.setFullName("centimeter");
        unit.setShortName("centm");
        unit.setDigitalCode(123);

        unitService.saveUnit(unit);
    }
}
