package com.example.crosslert_backend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AlphaVantageClientTest {
    
    @Autowired
    private AlphaVantageClient client;

    @Test
    public void AlphaVantageClientAPITest(){
        System.out.println(client.getStockData("IBM"));
    }

}
