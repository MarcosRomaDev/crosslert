package com.example.crosslert_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crosslert_backend.dto.stock.SymbolSearchDTO;

@Service
public class StockService {

    private final AlphaVantageClient alphaClient;

    public StockService(AlphaVantageClient alphaClient) {
        this.alphaClient = alphaClient;
    }

    public List<SymbolSearchDTO> getBestMatches(String keywords) {
        return alphaClient.searchSymbol(keywords).getBestMatches();
    }
}
