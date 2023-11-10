package com.kieran.reactiveweb.service;

import com.kieran.reactiveweb.model.CatFactResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class CatService {

    @Autowired
    private WebClient.Builder webClient;

    public Mono<List<CatFactResponse>> getFacts(String maxLength, String limit) {
        final String URL = "https://catfact.ninja/facts?max_length=" + maxLength + "&limit=" + limit;
        log.info("Calling cat API with path {}", URL);
        return webClient
                .build()
                .get()
                .uri(URL)
                .retrieve()
                .bodyToFlux(CatFactResponse.class)
                .collectList();
    }
}
