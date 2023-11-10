package com.kieran.reactiveweb.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class CatFactResponse {

    private List<CatFact> data;
}
