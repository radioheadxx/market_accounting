package com.kata.market_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    @ManyToMany(targetEntity = Contractor.class)
    private Set<Contractor> roles;
    @Column(name = "contractor_check")
    private String contractorCheck;
    @Column(name = "organization")
    private String organization;
    @Column(name = "organization_check")
    private String organizationCheck;
    @ManyToMany(targetEntity = Warehouses.class)
    private Set<Warehouses> warehouses;
    @Column(name = "Summ")
    private BigDecimal Summ;
    @ManyToMany(targetEntity = Currency.class)
    private Set<Currency> Currency;
    @Column(name = "payment_date")
    private String paymentDate;
    @Column(name = "paid")
    private String paid;
    @Column(name = "not_paid")
    private String notPaid;
    @Column(name = "shipped")
    private String shipped;
    @ManyToMany(targetEntity = Project.class)
    private Set<Project> project;
    @Column(name = "contract")
    private String contract;
    @ManyToMany(targetEntity = SaleChannel.class)
    private Set<SaleChannel> SaleChannel;
    @Column(name = "general_access")
    private Boolean generalAccess;
    @Column(name = "sent")
    private Boolean sent;
    @Column(name = "printed")
    private Boolean printed;
    @Column(name = "data_and_time")
    private String dataAndTime;
}
