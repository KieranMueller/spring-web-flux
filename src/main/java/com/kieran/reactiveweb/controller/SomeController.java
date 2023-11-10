package com.kieran.reactiveweb.controller;

import com.kieran.reactiveweb.model.Stuff;
import com.kieran.reactiveweb.service.SomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SomeController {

    @Autowired
    private SomeService someService;

    @GetMapping("get-stuff/{id}")
    public Stuff getSomething(@PathVariable int id) {
        return someService.getSomething(id);
    }
}
