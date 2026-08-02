package com.example.crosslert_backend.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crosslert_backend.dto.AlphaVantageDailyResponseDTO;

@SpringBootTest
public class AlphaVantageClientTest {
    
    @Autowired
    private AlphaVantageClient client;

    @Test
    void testGetStockData() {
        AlphaVantageDailyResponseDTO resultado = client.getStockData("IBM");
        assertNotNull(resultado.getMetadata());
        assertFalse(resultado.getDailyData().isEmpty());
    }

}
