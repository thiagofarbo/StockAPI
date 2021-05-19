package com.yahoofinance.resource;

import com.yahoofinance.StockRequest;
import com.yahoofinance.response.HistoricalQuoteResponse;
import com.yahoofinance.response.StockResponse;
import com.yahoofinance.service.StockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yahoofinance.Stock;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Api(value = "/stocks", produces = "application/json;charset=UTF-8", tags = { "Stocks" })
@ApiOperation(value = "stocks", notes = "Stock API", response = StockResource.class)
@ApiResponses({ @ApiResponse(code = 400, message = ""),
        @ApiResponse(code = 404, message = ""),
        @ApiResponse(code = 500, message = "") })
public class StockResource {

    @Autowired
    private StockService service;

    @GetMapping("/stocks/{ticker}")
    public ResponseEntity<StockResponse> getStock(@PathVariable final String ticker) throws IOException {
        return ResponseEntity.ok(service.getStockPrice(ticker));
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<StockResponse>> getStocks(@ModelAttribute("tickers") final StockRequest stock) throws IOException {
        return ResponseEntity.ok(service.getStockPrices(stock));
    }

    @GetMapping("/stocks/historical/quotes/{ticker}")
    public ResponseEntity<List<HistoricalQuoteResponse>> getStocks(@PathVariable final String ticker) throws IOException {
        return ResponseEntity.ok(service.getHistoricalQuote(ticker));
    }
}
