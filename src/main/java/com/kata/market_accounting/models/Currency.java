package com.kata.market_accounting.models;

public class Currency {
    private boolean isAccounting; //является ли валютой учета
    private String shortName;
    private String fullName;
    private short digitalCode;
    private String letterCode; // буквенный код
    private double exchangeRate; // курс
}
