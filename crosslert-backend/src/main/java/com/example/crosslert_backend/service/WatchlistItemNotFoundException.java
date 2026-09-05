package com.example.crosslert_backend.service;

public class WatchlistItemNotFoundException extends RuntimeException {
    public WatchlistItemNotFoundException(String message) {
        super(message);
    }
}
