package com.kata.market_accounting.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "status", schema = "market")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ContractorStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String description;

    @NonNull
    private String definition;

    @NonNull
    private Colors color;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<Contractor> contractors;

    public enum StatusDefinitions {
        USUAL("Обычный"),
        FINAL_POSITIVE("Финальный положительный"),
        FINAL_NEGATIVE("Финальный отрицательный");

        private String def;

        StatusDefinitions(String def) {
            this.def = def;
        }

        public String getDef() {
            return def;
        }
    }

    public enum Colors {
        GRAY, RED, ORANGE, BROWN, SAGE, CHARTREUSE, KHAKI, GREEN, LIGHT_BLUE, BLUE, INDIGO, DARK_BLUE, PINK, PURPLE, PLUM, BLACK
    }
}
