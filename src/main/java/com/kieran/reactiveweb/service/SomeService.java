package com.kieran.reactiveweb.service;

import com.kieran.reactiveweb.model.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class SomeService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Stuff getSomething(int id) {
        return webClientBuilder
                .build()
                .get()
                .uri("https://jsonplaceholder.typicode.com/todos/" + id)
                .retrieve()
                .bodyToMono(Stuff.class)
                .block();
    }
}
