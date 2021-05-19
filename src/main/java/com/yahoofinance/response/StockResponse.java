package com.yahoofinance.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class StockResponse implements Serializable {

    private String symbol;

    private String name;

    private String currency;

    private String stockExchange;

    private QuoteResponse quote;

    private List<HistoricalQuoteResponse> history;

    private String dividend;

}
