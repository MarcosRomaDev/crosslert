package com.example.crosslert_backend.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class WatchlistItemId {

    private Long userId;
    private String symbol;

    protected WatchlistItemId() {
    }

    public WatchlistItemId(Long userId, String symbol) {
        this.userId = userId;
        this.symbol = symbol;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof WatchlistItemId))
            return false;
        WatchlistItemId that = (WatchlistItemId) o;
        return Objects.equals(userId, that.userId) && Objects.equals(symbol, that.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, symbol);
    }

}
