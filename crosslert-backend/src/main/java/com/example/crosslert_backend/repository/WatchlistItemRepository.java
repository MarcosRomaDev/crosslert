package com.example.crosslert_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crosslert_backend.entity.WatchlistItem;
import com.example.crosslert_backend.entity.WatchlistItemId;

public interface WatchlistItemRepository extends JpaRepository<WatchlistItem, WatchlistItemId> {

    List<WatchlistItem> findByIdUserId(Long userId);

}
