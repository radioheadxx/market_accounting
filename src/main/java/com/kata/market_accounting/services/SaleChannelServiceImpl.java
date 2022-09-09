package com.kata.market_accounting.services;

import com.kata.market_accounting.models.SaleChannel;
import com.kata.market_accounting.repositories.SaleChannelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SaleChannelServiceImpl implements SaleChannelService {

    private final SaleChannelRepository saleChannelRepository;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public SaleChannelServiceImpl(SaleChannelRepository saleChannelRepository) {
        this.saleChannelRepository = saleChannelRepository;
    }


    @Override
    public List<SaleChannel> listSaleChannels() {
        return saleChannelRepository.findAll();
    }

    @Override
    public SaleChannel getSaleChannel(long id) {
        return saleChannelRepository.findById(id).get();
    }

    @Override
    public void createSaleChannel(SaleChannel saleChannel) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        saleChannel.setDateAndTime(formattedDateTime);
        saleChannelRepository.save(saleChannel);
    }

    @Override
    public void updateSaleChannel(SaleChannel saleChannel) {
        SaleChannel dbSaleChannel = saleChannelRepository.getReferenceById(saleChannel.getId());
        dbSaleChannel.setName(saleChannel.getName());
        dbSaleChannel.setType(saleChannel.getType());
        dbSaleChannel.setDescription(saleChannel.getDescription());
        dbSaleChannel.setGeneralAccess(saleChannel.getGeneralAccess());
        dbSaleChannel.setOwnerDepartment(saleChannel.getOwnerDepartment());
        dbSaleChannel.setOwnerEmployee(saleChannel.getOwnerEmployee());
        dbSaleChannel.setAuthor(saleChannel.getAuthor());

        LocalDateTime localDateTime = LocalDateTime.now();
        String formattedDateTime = localDateTime.format(formatter);
        dbSaleChannel.setDateAndTime(formattedDateTime);

        saleChannelRepository.flush();
    }

    @Override
    public void deleteSaleChannel(long id) {
        saleChannelRepository.deleteById(id);
    }
}
