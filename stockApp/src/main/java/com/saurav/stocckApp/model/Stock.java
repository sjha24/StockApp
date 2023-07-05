package com.saurav.stocckApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer stockId;
    @Column(unique = true)
    private String stockName;
    private Double stockPrice;
    private Integer stockOwnerCount;
    @Enumerated(value = EnumType.STRING)
    private StockType stockType;
    private LocalDate stockBirthTimeStamp;
}
