package com.yahoofinance.service;

import com.yahoofinance.StockRequest;
import com.yahoofinance.response.HistoricalQuoteResponse;
import com.yahoofinance.response.StockResponse;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Service
public class StockService {

    public StockResponse getStockPrice(final String ticker) throws IOException {

        final Stock stock = YahooFinance.get(ticker);

        ModelMapper mapper = new ModelMapper();
        final StockResponse stockResponse = mapper.map(stock, StockResponse.class);

        return stockResponse;
    }

    public List<StockResponse> getStockPrices(StockRequest stock) throws IOException {

        final List<StockResponse> stockList = new ArrayList<>();

        final Map<String, Stock> stocks = YahooFinance.get(stock.getTickers(), stock.isHistory());

        final List<Stock> stocksValue = new ArrayList<>(stocks.values());

        ModelMapper mapper = new ModelMapper();

        stocksValue.stream().forEach(s ->{
            StockResponse stockResponse = mapper.map(s, StockResponse.class);
            stockList.add(stockResponse);
        });

        return stockList;
    }

    public List<HistoricalQuoteResponse> getHistoricalQuote(final String ticker) throws IOException {

        final List<HistoricalQuoteResponse> historicalQuoteResponses = new ArrayList<>();

        final Stock stock = YahooFinance.get(ticker);

        final List<HistoricalQuote> history = stock.getHistory();

        ModelMapper mapper = new ModelMapper();

        history.stream().forEach(h -> {
            final HistoricalQuoteResponse historicalQuoteResponse = mapper.map(h, HistoricalQuoteResponse.class);
            historicalQuoteResponses.add(historicalQuoteResponse);
        });

        return historicalQuoteResponses;
    }
}
