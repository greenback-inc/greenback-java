package com.greenback.kit.model;

public enum ExchangeRateType {

    SETTLEMENT,               // if the exchange rate is what was settled to (e.g. paid out in)
    PRESENTMENT,             // if the exchanger rate is really what was presented in (e.g. marketed as)
    ESTIMATED;                 // an estimated exchange rate

}