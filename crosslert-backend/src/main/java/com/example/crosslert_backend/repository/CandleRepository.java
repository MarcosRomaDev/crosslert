package com.example.crosslert_backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crosslert_backend.entity.Candle;

public interface CandleRepository extends JpaRepository<Candle, Long> {

    Optional<Candle> findTopBySymbolOrderByDateDesc(String symbol);

}
