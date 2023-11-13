package com.kieran.reactiveweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    private String tickerSymbol;
    private Double pricePerShare;
    private Double percentChange;
}
