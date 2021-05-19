package com.yahoofinance.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteResponse implements Serializable {

    private BigDecimal price;

    private BigDecimal dayLow;

    private BigDecimal dayHigh;

}
