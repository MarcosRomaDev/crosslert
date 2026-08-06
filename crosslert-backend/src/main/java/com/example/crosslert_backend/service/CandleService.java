package com.example.crosslert_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;

import com.example.crosslert_backend.dto.AlphaVantageDailyResponseDTO;
import com.example.crosslert_backend.dto.DailyDataDTO;
import com.example.crosslert_backend.entity.Candle;
import com.example.crosslert_backend.repository.CandleRepository;

@Service
public class CandleService {

    private final CandleRepository candleRepo;
    private final AlphaVantageClient alphaClient;

    public CandleService(CandleRepository candleRepo, AlphaVantageClient alphaClient) {
        this.candleRepo = candleRepo;
        this.alphaClient = alphaClient;
    }

    public List<Candle> getCandleBySymbol(String symbol) {
        Optional<Candle> lastCandle = candleRepo.findTopBySymbolOrderByDateDesc(symbol);
        List<Candle> candles = new ArrayList<>();

        boolean needsApi = lastCandle.isEmpty()
                || ChronoUnit.DAYS.between(lastCandle.get().getDate(), LocalDate.now()) > 3;

        if (needsApi) {
            AlphaVantageDailyResponseDTO dto = alphaClient.getStockData(symbol);
            for (Map.Entry<String, DailyDataDTO> entry : dto.getDailyData().entrySet()) {
                DailyDataDTO daily = entry.getValue();
                Candle candle = new Candle();
                candle.setSymbol(symbol);
                candle.setDate(LocalDate.parse(entry.getKey()));
                candle.setOpen(daily.getOpen());
                candle.setHigh(daily.getHigh());
                candle.setLow(daily.getLow());
                candle.setClose(daily.getClose());
                candle.setVolume(daily.getVolume());
                candles.add(candle);
            }
            candleRepo.saveAll(candles);
        } else {
            candles = candleRepo.findBySymbol(symbol);
        }
        return candles;
    }
}
