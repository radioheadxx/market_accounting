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

@Entity(name = "currencies")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="is_accounting")
    private Boolean isAccounting; //является ли валютой учета

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
    private String letterCode; // буквенный код

    @Column(name="exchange_rate")
    private Double exchangeRate; // курс
}
