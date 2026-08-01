package com.example.crosslert_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.crosslert_backend.entity.Candle;

public interface CandleRepository extends JpaRepository<Candle, Long> {

}
