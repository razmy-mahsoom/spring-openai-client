package com.efuturesworld.library;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.efuturesworld.client.OpenAIClient;

@EnableFeignClients(clients = OpenAIClient.class)
@ComponentScan(basePackages = {"com.efuturesworld.*"})
@Configuration
@PropertySource(value = "classpath:efuturesworld-openai-spring-client-properties.yml",factory = YamlPropertySourceFactory.class)
public class OpenAiSpringClientLibraryConfig {
}
