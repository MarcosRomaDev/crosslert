package com.example.crosslert_backend.dto.stock;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SymbolSearchBestMatchesDTO {

    @JsonProperty("bestMatches")
    private List<AlphaVantageSymbolSearchDTO> symbolSearch;

    public List<AlphaVantageSymbolSearchDTO> getBestMatches() {
        return symbolSearch;
    }

    public void setBestMatches(List<AlphaVantageSymbolSearchDTO> symbolSearch) {
        this.symbolSearch = symbolSearch;
    }

}
