package com.example.crosslert_backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.crosslert_backend.dto.candle.AlphaVantageDailyResponseDTO;
import com.example.crosslert_backend.dto.stock.SymbolSearchBestMatchesDTO;

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

    public SymbolSearchBestMatchesDTO searchSymbol(String keywords) {
    return restClient.get()
            .uri(uriBuilder -> uriBuilder
                .path("/query")
                .queryParam("function", "SYMBOL_SEARCH")
                .queryParam("keywords", keywords)
                .queryParam("apikey", apiKey)
                .build())
            .retrieve()
            .body(SymbolSearchBestMatchesDTO.class);
}

    
}
