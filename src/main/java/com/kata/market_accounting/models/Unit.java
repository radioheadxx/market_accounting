package com.kata.market_accounting.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "units", schema = "market")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String fullName;
    @NotNull
    @Column
    private String shortName;
    @Column
    private int digitalCode;
    @Column(name = "type")
    private String type;
    @Column
    private boolean generalAccess;
    @Column
    private String ownerDepartment;
    @Column
    private String ownerEmployee;
    @Column
    private String changeTime;
    @Column
    private String whoChanged;

    public Unit(Long id, String fullName, String shortName, int digitalCode) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.digitalCode = digitalCode;
    }
}
