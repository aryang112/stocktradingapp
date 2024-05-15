package com.example.stocktradingapp.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.stocktradingapp.dto.StockDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class StockService {
    
    private static final String API_FUNCTION = "GLOBAL_QUOTE";


    @Value("${alphavantage.apikey}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public StockService(RestTemplate restTemplatem) {
        this.restTemplate = new RestTemplate();
    }

    public StockDTO getStockPrice(String symbol) {
        
        
        String url = UriComponentsBuilder.fromHttpUrl("https://www.alphavantage.co/query")
        .queryParam("function", API_FUNCTION)
        .queryParam("symbol", symbol)
        .queryParam("apikey", apiKey)
        .toUriString();

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        Map<String, Object> globalQuote = (Map<String, Object>) response.get("Global Quote");
        
        return mapToStockDTO(globalQuote);
        
    }

    private StockDTO mapToStockDTO(Map<String, Object> globalQuote) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setSymbol((String) globalQuote.get("01. symbol"));
        stockDTO.setOpen((String) globalQuote.get("02. open"));
        stockDTO.setHigh((String) globalQuote.get("03. high"));
        stockDTO.setLow((String) globalQuote.get("04. low"));
        stockDTO.setPrice((String) globalQuote.get("05. price"));
        stockDTO.setVolume((String) globalQuote.get("06. volume"));
        stockDTO.setLatestTradingDay((String) globalQuote.get("07. latest trading day"));
        stockDTO.setPreviousClose((String) globalQuote.get("08. previous close"));
        stockDTO.setChange((String) globalQuote.get("09. change"));
        stockDTO.setChangePercent((String) globalQuote.get("10. change percent"));
        return stockDTO;
    }
}
