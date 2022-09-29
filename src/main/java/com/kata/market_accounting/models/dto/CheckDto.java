package com.kata.market_accounting.models.dto;

import com.kata.market_accounting.models.Contractor;
import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.models.Project;
import com.kata.market_accounting.models.SaleChannel;
import com.kata.market_accounting.models.Warehouses;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CheckDto {
    private Long id;
    private Long number;
    private String time;
    private Contractor contractor;
    private String contractorCheck;
    private String organization;
    private String organizationCheck;
    private Warehouses warehouses;
    private BigDecimal Summ;
    private Currency currency;
    private String paymentDate;
    private String paid;
    private String notPaid;
    private String shipped;
    private Project project;
    private String contract;
    private SaleChannel SaleChannel;
    private Boolean generalAccess;
    private Boolean sent;
    private Boolean printed;
    private String dataAndTime;
}
