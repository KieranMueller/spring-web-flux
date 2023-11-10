package com.kieran.reactiveweb.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class Stuff {

    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
