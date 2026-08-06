package com.example.crosslert_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crosslert_backend.entity.Candle;
import com.example.crosslert_backend.entity.CandleId;

import java.util.List;


public interface CandleRepository extends JpaRepository<Candle, CandleId> {

    Optional<Candle> findTopBySymbolOrderByDateDesc(String symbol);
    List<Candle> findBySymbol(String symbol);
}
