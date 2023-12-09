package com.efuturesworld.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class AuthorizationInterceptor implements RequestInterceptor {
    private final ClientConfigProvider configProvider;

    @Autowired
    public AuthorizationInterceptor(ClientConfigProvider configProvider) {
        this.configProvider = configProvider;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Content-Type", configProvider.getContentType());
        requestTemplate.header("Authorization","Bearer "+configProvider.getApiKey());
        String requestString = requestTemplate.request().toString();
        log.info("request {}",requestString);
    }
}
