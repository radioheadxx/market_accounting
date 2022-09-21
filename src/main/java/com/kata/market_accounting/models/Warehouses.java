package com.kata.market_accounting.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Column(name = "name")
    private String name;
    @Column(name = "cod")
    private Long cod;
    @Column(name = "address")
    private String address;
    @Column(name = "access")
    private Boolean access;


    public Warehouses(Long id, String name, Long cod, String address, boolean access) {
        this.id = id;
        this.name = name;
        this.cod = cod;
        this.address = address;
        this.access = access;
    }
}
