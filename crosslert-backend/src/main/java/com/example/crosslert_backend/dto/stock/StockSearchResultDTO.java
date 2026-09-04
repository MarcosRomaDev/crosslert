package com.example.crosslert_backend.dto.stock;

public class StockSearchResultDTO {

    private String symbol;
    private String name;

    public StockSearchResultDTO(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
