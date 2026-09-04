package com.example.crosslert_backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.crosslert_backend.dto.stock.AlphaVantageSymbolSearchDTO;
import com.example.crosslert_backend.dto.stock.StockSearchResultDTO;
import com.example.crosslert_backend.dto.stock.SymbolSearchBestMatchesDTO;

class StockServiceTest {

    @Test
    void getBestMaps_shouldReturnCleanDtoWithSymbolAndName() {
        AlphaVantageClient mockClient = mock(AlphaVantageClient.class);

        AlphaVantageSymbolSearchDTO external = new AlphaVantageSymbolSearchDTO();
        external.setSymbol("AAPL");
        external.setName("Apple Inc");

        SymbolSearchBestMatchesDTO stubResponse = new SymbolSearchBestMatchesDTO();
        stubResponse.setBestMatches(List.of(external));

        when(mockClient.searchSymbol("apple")).thenReturn(stubResponse);

        StockService service = new StockService(mockClient);

        List<StockSearchResultDTO> result = service.getBestMatches("apple");

        assertEquals(1, result.size());
        assertEquals("AAPL", result.get(0).getSymbol());
        assertEquals("Apple Inc", result.get(0).getName());
    }
}
