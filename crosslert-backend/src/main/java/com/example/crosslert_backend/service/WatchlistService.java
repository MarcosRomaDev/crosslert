package com.example.crosslert_backend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crosslert_backend.entity.WatchlistItem;
import com.example.crosslert_backend.entity.WatchlistItemId;
import com.example.crosslert_backend.repository.WatchlistItemRepository;

@Service
public class WatchlistService {
    private final WatchlistItemRepository repo;

    public WatchlistService(WatchlistItemRepository repo) {
        this.repo = repo;
    }

    public List<WatchlistItem> list() {
        Long userId = CurrentUser.getCurrentUserId();
        return repo.findByIdUserId(userId);
    }

    public WatchlistItem add(String symbol) {
        String upper = symbol.toUpperCase();
        WatchlistItemId id = new WatchlistItemId(CurrentUser.getCurrentUserId(), upper);
        WatchlistItem item = new WatchlistItem();
        item.setId(id);
        item.setFechaAnadido(LocalDateTime.now());
        return repo.save(item);
    }

    public void delete(String symbol) {
        String upper = symbol.toUpperCase();
        WatchlistItemId id = new WatchlistItemId(CurrentUser.getCurrentUserId(), upper);
        if (!repo.existsById(id)) {
            throw new WatchlistItemNotFoundException("Watchlist item no encontrado: " + symbol);
        }
        repo.deleteById(id);
    }

}
