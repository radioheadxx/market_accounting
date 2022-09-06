package com.kata.market_accounting.models.dto;

import lombok.NonNull;

import javax.persistence.Column;

public class CurrencyDto {
    private Long id;

    private Boolean isAccounting; //является ли валютой учета

    private String shortName;

    private String fullName;

    private String digitalCode;

    private String letterCode; // буквенный код

    private Double exchangeRate; // курс
}
