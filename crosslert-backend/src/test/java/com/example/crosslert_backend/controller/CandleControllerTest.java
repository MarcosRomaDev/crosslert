package com.example.crosslert_backend.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.crosslert_backend.entity.Candle;

@AutoConfigureTestRestTemplate
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CandleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetStock() {
        Candle[] candles = restTemplate.getForObject("/api/candles/MSFT", Candle[].class);
        assertNotNull(candles);
        assertTrue(candles.length > 0);
    }
}
