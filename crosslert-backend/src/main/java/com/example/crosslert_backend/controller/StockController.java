package com.example.crosslert_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.crosslert_backend.dto.stock.SymbolSearchDTO;
import com.example.crosslert_backend.service.StockService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/api/search/{keywords}")
    public List<SymbolSearchDTO> search(@PathVariable String keywords) {
        return stockService.getBestMatches(keywords);
    }
}
