package com.kata.market_accounting.services;


import com.kata.market_accounting.models.SaleChannel;

import java.util.List;

public interface SaleChannelService {
    List<SaleChannel> listSaleChannels();
    SaleChannel getSaleChannel(long id);
    void createSaleChannel(SaleChannel saleChannel);
    SaleChannel updateSaleChannel(SaleChannel saleChannel);
    void deleteSaleChannel(long id);
}
