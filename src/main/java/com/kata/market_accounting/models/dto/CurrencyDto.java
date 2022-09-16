package com.kata.market_accounting.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrencyDto {
    private Long id;

    private Boolean isAccounting;

    private String shortName;

    private String fullName;

    private String digitalCode;

    private String letterCode;

    private Double exchangeRate;

    private boolean commonAccess;

    private String dateEdit;

    private String ownerDepartment;

    private String ownerEmployee;

    private String author;
}
