package com.kieran.reactiveweb.controller;

import com.kieran.reactiveweb.model.CatFactResponse;
import com.kieran.reactiveweb.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class CatController {

    @Autowired
    private CatService catService;

    @GetMapping("catfacts")
    public Mono<List<CatFactResponse>> getSomething(
            @RequestParam("max_length") String maxLength, @RequestParam String limit) {
        return catService.getFacts(maxLength, limit);
    }
}
