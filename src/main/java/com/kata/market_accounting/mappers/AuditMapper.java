package com.kata.market_accounting.mappers;

import com.kata.market_accounting.models.Audit;
import com.kata.market_accounting.models.dto.AuditDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditMapper extends BaseMapper<Audit, AuditDto> {
}
