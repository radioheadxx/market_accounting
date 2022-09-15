package com.kata.market_accounting.services;

import com.kata.market_accounting.models.VATRate;

import java.util.List;

public interface VATRateService {
    List<VATRate> listRates();
    VATRate getRate(long id);
    void createRate(VATRate rate);
    void updateRate(VATRate rate);
    void deleteRate(long id);
}
