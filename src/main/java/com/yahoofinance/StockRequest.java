package com.yahoofinance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {

    private String[] tickers;

    private boolean isHistory;
}
