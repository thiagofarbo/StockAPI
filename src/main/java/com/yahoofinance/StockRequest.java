package com.yahoofinance;

import com.yahoofinance.domain.Stock;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockRequest {

    private String[] tickers;

    private boolean isHistory;
}
