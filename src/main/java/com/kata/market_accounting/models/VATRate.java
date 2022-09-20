package com.kata.market_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "value_added_tax_rate", schema = "market")
public class VATRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="type")
    private String type;
    @Column(name="rate")
    private int rate;
    @Column(name="comment")
    private String comment;
    @Column(name="general_access")
    private Boolean generalAccess;
    @Column(name="owner_department")
    private String ownerDepartment;
    @Column(name="owner_employee")
    private String ownerEmployee;
    @Column(name="date_and_time")
    private String dateAndTime;
    @Column(name="author")
    private String author;
}
