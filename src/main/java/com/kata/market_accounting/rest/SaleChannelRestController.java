package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.SaleChannel;
import com.kata.market_accounting.services.SaleChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "Sale channel controller")
@RequestMapping("/api/sale_channels")
public class SaleChannelRestController {

    private final SaleChannelService saleChannelService;

    public SaleChannelRestController(SaleChannelService saleChannelService) {
        this.saleChannelService = saleChannelService;
    }

    @GetMapping
    @ApiOperation("Get list of sale channels")
    public List<SaleChannel> listSaleChannels() {
        return saleChannelService.listSaleChannels();
    }

    @GetMapping("/{id}")
    @ApiOperation("Get single sale channel by ID")
    public SaleChannel getSaleChannel(@PathVariable("id") Long id) {
        return saleChannelService.getSaleChannel(id);
    }

    @PostMapping
    @ApiOperation("Create sale channel")
    void createSaleChannel(@RequestBody SaleChannel saleChannel) {
        saleChannelService.createSaleChannel(saleChannel);
    }

    @PutMapping
    @ApiOperation("Edit sale channel")
    void updateSaleChannel(@RequestBody SaleChannel saleChannel) {
        saleChannelService.updateSaleChannel(saleChannel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete sale channel by ID")
    void deleteSaleChannel(@PathVariable("id") Long id) {
        saleChannelService.deleteSaleChannel(id);
    }
}
