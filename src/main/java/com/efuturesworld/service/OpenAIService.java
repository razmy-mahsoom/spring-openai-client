package com.efuturesworld.service;

import com.efuturesworld.client.OpenAIClient;
import com.efuturesworld.dto.response.model.Model;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class OpenAIService {

    private final OpenAIClient client;
    private final ExecutorService executorService;

    public OpenAIService(OpenAIClient client, ExecutorService executorService) {
        this.client = client;
        this.executorService = executorService;
    }

    public CompletableFuture<List<Model>> listModels(){
        CompletableFuture<List<Model>> listCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return client.listModels().getBody().data;
        }, executorService);
        return listCompletableFuture;
    }


}
