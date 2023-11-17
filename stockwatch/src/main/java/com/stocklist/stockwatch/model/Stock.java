package com.stocklist.stockwatch.model;

/* 
 * stock class based on below structure
 *  Use Lombok Annotations
 * Make this class as Entity class with primary key as symbol*/
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    private String symbol;
    private String name;
    private String currency;
    private String exchange;
    private String mic_code;
    private String country;
    private String type;
}
