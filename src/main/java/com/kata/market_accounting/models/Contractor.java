package com.kata.market_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "contractors", schema = "market")
@Data
@NoArgsConstructor
public class Contractor {
    @Id
    private Long id;

    @Column
    @NonNull
    private String name;
    private String code;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private String phone;
    private String fax;
    private String email;
    private String status;

    @Column(name = "discount_card")
    private String discountCard;

    @Column(name = "fact_address")
    private String factAddress;
    private String comments;
    private String groups;

    @Column(name = "contractor_type")
    private String contractorType;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "legal_address")
    private String legalAddress;
    private String TIN;
    private String CRR;
    private String bank;

    @Column(name = "checking_account")
    private String checkingAccount;
    private String prices;

    @Column(name = "is_common")
    private boolean isCommon;

    @Column(name = "owner_dept")
    private String ownerDept;

    @Column(name = "owner_employee")
    private String ownerEmployee;

    @Column(name = "first_sale")
    private String firstSale;

    @Column(name ="last_sale")
    private String last_sale;

    @Column(name = "number_of_sales")
    private String numOfSales;

    @Column(name = "sales_sum")
    private double salesSum;

    @Column(name = "average_check")
    private double avgCheck;

    @Column(name = "number_of_returns")
    private int numOfReturns;
    private double balance;
    private double profit;

    @Column(name = "last_event_date")
    private String lastEventDate;

    @Column(name = "event_text")
    private String eventText;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    @Column(name = "who_changed")
    private String changedWho;
}
