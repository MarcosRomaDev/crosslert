package com.example.crosslert_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.crosslert_backend.entity.Candle;
import com.example.crosslert_backend.service.CandleService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class CandleController {
    private final CandleService candleService;

    public CandleController(CandleService candleService) {
        this.candleService = candleService;
    }

    @GetMapping("/api/candles/{symbol}")
    public List<Candle> getStock(@PathVariable String symbol) {
        return candleService.getCandleBySymbol(symbol);
    }

}
