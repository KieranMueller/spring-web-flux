package com.kieran.reactiveweb.service;

import com.kieran.reactiveweb.dao.StockRepository;
import com.kieran.reactiveweb.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@Slf4j
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocksBlocking() {
        long start = System.currentTimeMillis();
        List<Stock> stocks = stockRepository.getAllStocksBlocking();
        long end = System.currentTimeMillis();
        log.info("Time taken to process request: " + (end - start) + "ms");
        return stocks;
    }

    public Flux<Stock> getAllStocksAsync() {
        long start = System.currentTimeMillis();
        Flux<Stock> stocks = stockRepository.getAllStocksAsync();
        long end = System.currentTimeMillis();
        log.info("Time taken to process request: " + (end - start) + "ms");
        log.info("Look! I'm executed before the request is complete!");
        return stocks;
    }
}
