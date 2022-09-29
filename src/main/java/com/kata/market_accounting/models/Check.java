package com.kata.market_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.math.BigDecimal;

import java.util.Set;

@Entity
@Table(name = "check", schema = "market")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Check {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "number")
    private Long number;
    @Column(name = "time")
    private String time;
    @ManyToOne
    @JoinColumn(name = "contractor_id")
    private Contractor contractor;
    @Column(name = "contractor_check")
    private String contractorCheck;
    @Column(name = "organization")
    private String organization;
    @Column(name = "organization_check")
    private String organizationCheck;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Warehouses warehouses;
    @Column(name = "Summ")
    private BigDecimal Summ;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @Column(name = "payment_date")
    private String paymentDate;
    @Column(name = "paid")
    private String paid;
    @Column(name = "not_paid")
    private String notPaid;
    @Column(name = "shipped")
    private String shipped;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @Column(name = "contract")
    private String contract;
    @ManyToOne
    @JoinColumn(name = "sale_channel_id")
    private SaleChannel SaleChannel;
    @Column(name = "general_access")
    private Boolean generalAccess;
    @Column(name = "sent")
    private Boolean sent;
    @Column(name = "printed")
    private Boolean printed;
    @Column(name = "data_and_time")
    private String dataAndTime;
}
