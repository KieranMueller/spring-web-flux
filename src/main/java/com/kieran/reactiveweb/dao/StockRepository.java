package com.kieran.reactiveweb.dao;

import com.kieran.reactiveweb.model.Stock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
@Slf4j
public class StockRepository {

    private static void sleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Stock> getAllStocksBlocking() {
        return IntStream
                .rangeClosed(1, 5)
                .peek(StockRepository::sleep)
                .peek(i -> log.info("Processing stock number: " + i))
                .mapToObj(i -> new Stock("AB" + i, i * (0.87 + i), 0.2 * i))
                .collect(Collectors.toList());
    }

    public Flux<Stock> getAllStocksAsync() {
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> log.info("Processing stock number: " + i))
                .map(i -> new Stock("AB" + i, i * (0.87 + i), 0.2 * i));
    }
}
