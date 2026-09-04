package com.example.crosslert_backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crosslert_backend.dto.stock.AlphaVantageSymbolSearchDTO;
import com.example.crosslert_backend.dto.stock.StockSearchResultDTO;

@Service
public class StockService {

    private final AlphaVantageClient alphaClient;

    public StockService(AlphaVantageClient alphaClient) {
        this.alphaClient = alphaClient;
    }

    public List<StockSearchResultDTO> getBestMatches(String keywords) {

        List<AlphaVantageSymbolSearchDTO> bestMatchJSON = alphaClient.searchSymbol(keywords).getBestMatches();
        List<StockSearchResultDTO> stockSearchResultList = new ArrayList<>();

        for (AlphaVantageSymbolSearchDTO alphaVantageSymbolSearchDTO : bestMatchJSON) {

            String symbol = alphaVantageSymbolSearchDTO.getSymbol();
            String name = alphaVantageSymbolSearchDTO.getName();

            StockSearchResultDTO searchResult = new StockSearchResultDTO(symbol, name);

            stockSearchResultList.add(searchResult);
        }

        return stockSearchResultList;
    }
}
