package com.example.crosslert_backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class WatchlistItem {

    @EmbeddedId
    private WatchlistItemId id;
    private LocalDateTime fechaAnadido;

    public WatchlistItemId getId() {
        return id;
    }

    public void setId(WatchlistItemId id) {
        this.id = id;
    }

    public LocalDateTime getFechaAnadido() {
        return fechaAnadido;
    }

    public void setFechaAnadido(LocalDateTime fechaAnadido) {
        this.fechaAnadido = fechaAnadido;
    }
}
