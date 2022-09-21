package com.kata.market_accounting.models.dto;

import lombok.Data;

@Data
public class ContractorDto {
    private Long id;
    private String name;
    private String code;
    private String createdAt;
    private String phone;
    private String fax;
    private String email;
    private String status;
    private String discountCard;
    private String factAddress;
    private String comment;
    private String groups;
    private String contractorType;
    private String fullName;
    private String legalAddress;
    private String TIN;
    private String CRR;
    private String bank;
    private String checkingAccount;
    private String prices;
    private boolean isCommon;
    private String ownerDept;
    private String ownerEmployee;
    private String firstSale;
    private String lastSale;
    private String numOfSales;
    private double salesSum;
    private double avgCheck;
    private int numbOfReturns;
    private double balance;
    private double profit;
    private String lastEventDate;
    private String eventText;
}
