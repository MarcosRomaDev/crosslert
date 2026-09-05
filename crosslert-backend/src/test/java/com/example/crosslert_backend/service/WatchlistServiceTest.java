package com.example.crosslert_backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.crosslert_backend.entity.WatchlistItem;
import com.example.crosslert_backend.entity.WatchlistItemId;
import com.example.crosslert_backend.repository.WatchlistItemRepository;

class WatchlistServiceTest {

    @Test
    void list_shouldReturnItemsForCurrentUser() {
        WatchlistItemRepository mockRepo = mock(WatchlistItemRepository.class);
        WatchlistService service = new WatchlistService(mockRepo);

        WatchlistItem item = new WatchlistItem();
        item.setId(new WatchlistItemId(1L, "AAPL"));
        when(mockRepo.findByIdUserId(1L)).thenReturn(List.of(item));

        List<WatchlistItem> result = service.list();

        assertEquals(1, result.size());
        assertEquals("AAPL", result.get(0).getId().getSymbol());
        verify(mockRepo).findByIdUserId(1L);
    }

    @Test
    void add_shouldNormalizeSymbolAndSetFechaAnadido() {
        WatchlistItemRepository mockRepo = mock(WatchlistItemRepository.class);
        WatchlistService service = new WatchlistService(mockRepo);

        when(mockRepo.save(any(WatchlistItem.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        WatchlistItem result = service.add("aapl");

        assertEquals("AAPL", result.getId().getSymbol());
        assertNotNull(result.getFechaAnadido());
        assertTrue(result.getFechaAnadido().isBefore(LocalDateTime.now().plusSeconds(1)));
    }

    @Test
    void delete_shouldCallDeleteByIdWhenExists() {
        WatchlistItemRepository mockRepo = mock(WatchlistItemRepository.class);
        WatchlistService service = new WatchlistService(mockRepo);

        WatchlistItemId id = new WatchlistItemId(1L, "AAPL");
        when(mockRepo.existsById(id)).thenReturn(true);

        service.delete("aapl");

        verify(mockRepo).existsById(id);
        verify(mockRepo).deleteById(id);
    }

    @Test
    void delete_shouldThrowWhenNotExists() {
        WatchlistItemRepository mockRepo = mock(WatchlistItemRepository.class);
        WatchlistService service = new WatchlistService(mockRepo);

        WatchlistItemId id = new WatchlistItemId(1L, "AAPL");
        when(mockRepo.existsById(id)).thenReturn(false);

        assertThrows(WatchlistItemNotFoundException.class, () -> service.delete("aapl"));
        verify(mockRepo, never()).deleteById(any());
    }
}
