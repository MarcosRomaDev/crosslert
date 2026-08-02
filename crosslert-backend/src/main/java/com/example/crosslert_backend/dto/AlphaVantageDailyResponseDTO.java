package com.example.crosslert_backend.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlphaVantageDailyResponseDTO {

    @JsonProperty("Meta Data")
    private MetaDataDTO metadata;

    @JsonProperty("Time Series (Daily)")
    private Map<String, DailyDataDTO> dailyData;

    public MetaDataDTO getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaDataDTO metadata) {
        this.metadata = metadata;
    }

    public Map<String, DailyDataDTO> getDailyData() {
        return dailyData;
    }

    public void setDailyData(Map<String, DailyDataDTO> dailyData) {
        this.dailyData = dailyData;
    }

}
