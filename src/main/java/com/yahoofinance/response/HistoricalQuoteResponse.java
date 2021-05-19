package com.yahoofinance.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class HistoricalQuoteResponse implements Serializable {

    private String symbol;

    private Calendar date;

    private BigDecimal open;

    private BigDecimal low;

    private BigDecimal high;

    private BigDecimal close;

    private BigDecimal adjClose;

    private Long volume;
}
