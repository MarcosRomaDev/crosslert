package com.example.crosslert_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EmbeddedId;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity

public class Candle {

    @EmbeddedId
    private CandleId id;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private Integer volume;
    private LocalDateTime cacheDate;

    public CandleId getId() {
        return id;
    }
    public void setId(CandleId id) {
        this.id = id;
    }
    public LocalDate getDate() {
        return id != null ? id.getDate() : null;
    }
    public void setDate(LocalDate date) {
        if (id == null) id = new CandleId();
        id.setDate(date);
    }
    public String getSymbol() {
        return id != null ? id.getSymbol() : null;
    }
    public void setSymbol(String symbol) {
        if (id == null) id = new CandleId();
        id.setSymbol(symbol);
    }
    public BigDecimal getOpen() {
        return open;
    }
    public void setOpen(BigDecimal open) {
        this.open = open;
    }
    public BigDecimal getHigh() {
        return high;
    }
    public void setHigh(BigDecimal high) {
        this.high = high;
    }
    public BigDecimal getLow() {
        return low;
    }
    public void setLow(BigDecimal low) {
        this.low = low;
    }
    public BigDecimal getClose() {
        return close;
    }
    public void setClose(BigDecimal close) {
        this.close = close;
    }
    public Integer getVolume() {
        return volume;
    }
    public void setVolume(Integer volume) {
        this.volume = volume;
    }
    public LocalDateTime getCacheDate() {
        return cacheDate;
    }
    public void setCacheDate(LocalDateTime cacheDate) {
        this.cacheDate = cacheDate;
    }

}
