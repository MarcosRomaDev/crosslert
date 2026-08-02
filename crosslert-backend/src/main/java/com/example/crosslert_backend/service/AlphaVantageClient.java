package com.example.crosslert_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.crosslert_backend.dto.AlphaVantageDailyResponseDTO;

@Service
public class AlphaVantageClient {
    private final RestClient restClient;
    @Value("${alpha.vantage.api.key}")
    private String apiKey;

    public AlphaVantageClient(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://www.alphavantage.co").build();
    }   

    
    public AlphaVantageDailyResponseDTO getStockData(String symbol) {
        AlphaVantageDailyResponseDTO data = restClient.get()
                        .uri(uriBuilder -> uriBuilder
                            .path("/query")
                            .queryParam("function", "TIME_SERIES_DAILY")
                            .queryParam("symbol", symbol).queryParam("apikey", apiKey)
                            .build())
                        .retrieve()
                        .body(AlphaVantageDailyResponseDTO.class);
        return data;
    }

    
}
