package com.kata.market_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currencies", schema = "market")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="is_accounting")
    private Boolean isAccounting;

    @NonNull
    @Column(name="short_name")
    private String shortName;

    @NonNull
    @Column(name="full_name")
    private String fullName;

    @Column(name="digital_code")
    private String digitalCode;

    @NonNull
    @Column(name="letter_code")
    private String letterCode;

    @Column(name="exchange_rate")
    private Double exchangeRate;

    @Column(name="common_access")
    private boolean commonAccess;

    @Column(name="date_edited")
    private String dateEdit;

    @Column(name="owner_department")
    private String ownerDepartment;

    @Column(name="owner_employee")
    private String ownerEmployee;

    @Column(name="author")
    private String author;
}
