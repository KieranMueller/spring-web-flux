package com.kieran.reactiveweb.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class CatFact {

    private String fact;
    private int length;
}
