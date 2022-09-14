package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Employee;
import com.kata.market_accounting.models.dto.EmployeeDto;
import org.mapstruct.factory.Mappers;

public interface EmployeeMapper {


    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toDto(Employee unit);
}
