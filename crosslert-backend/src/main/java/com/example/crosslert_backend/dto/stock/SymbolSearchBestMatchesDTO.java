package com.example.crosslert_backend.dto.stock;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SymbolSearchBestMatchesDTO {

    @JsonProperty("bestMatches")
    private List<SymbolSearchDTO> symbolSearch;

    public List<SymbolSearchDTO> getBestMatches(){
        return symbolSearch;
    }

    public void setBestMatches(List<SymbolSearchDTO> symbolSearch){
        this.symbolSearch = symbolSearch; 
    }

}
