package com.kata.market_accounting.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
public class Contractor {
    @Id
    private Long id;
    private String name;
    private String code;
    private LocalDateTime createdAt;
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
    private String secondSale;
    private String numberOfSales;
    private double salesSum;
    private double averageCheck;
    private int numberOfReturns;
    private double balance;
    private double profit;
    private String lastEventDate;
    private String eventText;
    private LocalDateTime changedAt;
    private String changedWho;
}
