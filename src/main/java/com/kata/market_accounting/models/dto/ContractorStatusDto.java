package com.kata.market_accounting.models.dto;

import com.kata.market_accounting.models.ContractorStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractorStatusDto {
    private long id;
    private String description;
    private ContractorStatus.StatusDefinitions definition;
    private ContractorStatus.Colors color;
}
