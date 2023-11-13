package com.kieran.reactiveweb.controller;

import com.kieran.reactiveweb.model.Stock;
import com.kieran.reactiveweb.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("stocks")
public class StocksController {

    @Autowired
    private StockService stockService;

    @GetMapping("blocking")
    public List<Stock> getAllStocksBlocking() {
        return stockService.getAllStocksBlocking();
    }

    @GetMapping(value = "async", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Stock> getAllStocksAsync() {
        return stockService.getAllStocksAsync();
    }
}
