package com.kata.market_accounting.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "audits", schema = "market")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    @Column
    String time;
    @Column
    String employee;
    @Column
    String event;

    public Audit(Long id, String employee, String event) {
        this.id = id;
        this.employee = employee;
        this.event = event;
    }
}