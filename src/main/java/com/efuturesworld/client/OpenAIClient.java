package com.efuturesworld.client;

import com.efuturesworld.config.AuthorizationInterceptor;
import com.efuturesworld.dto.ListResponseWrapper;
import com.efuturesworld.dto.response.model.Model;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(value = "open-ai-api",url = "https://api.openai.com/",configuration = AuthorizationInterceptor.class,dismiss404 = true)
public interface OpenAIClient {

    @GetMapping("v1/models")
    ResponseEntity<ListResponseWrapper<Model>> listModels();
}
