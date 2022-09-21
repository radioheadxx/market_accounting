package com.kata.market_accounting.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity(name = "warehouses")
@Table(name = "warehouses", schema = "market")
public class Warehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @Column(name = "name")
    private String name;
    @Column(name = "cod")
    private Long cod;
    @Column(name = "address")
    private String address;
    @Column(name = "access")
    private Boolean access;

    public Warehouses(String s, String test_warehouses_one, String tst1) {
    }
}
