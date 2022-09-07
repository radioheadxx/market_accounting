package com.kata.market_accounting.rest;

import com.kata.market_accounting.models.SaleChannel;
import com.kata.market_accounting.services.SaleChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @ApiOperation(value = "Get list of sale channels",
            notes = "Returns a full list of sale channels from the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<List<SaleChannel>> listSaleChannels() {
        return ResponseEntity.ok(saleChannelService.listSaleChannels());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get single sale channel by ID",
            notes = "Returns a sale channel by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved")
    })
    public ResponseEntity<SaleChannel> getSaleChannel(@PathVariable("id") Long id) {
        return ResponseEntity.ok(saleChannelService.getSaleChannel(id));
    }

    @PostMapping
    @ApiOperation(value = "Create sale channel",
            notes = "Creates a new sale channel and saves it to the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sale channel successfully created")
    })
    public ResponseEntity<Void> createSaleChannel(@RequestBody SaleChannel saleChannel) {
        saleChannelService.createSaleChannel(saleChannel);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Edit sale channel",
            notes = "Allows to change existing channel in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sale channel successfully edited")
    })
    public ResponseEntity<Void> updateSaleChannel(@RequestBody SaleChannel saleChannel) {
        saleChannelService.updateSaleChannel(saleChannel);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete sale channel by ID",
            notes = "Deletes a sale channel by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sale channel successfully deleted")
    })
    public ResponseEntity<Void> deleteSaleChannel(@PathVariable("id") @ApiParam(
                    name = "id", value = "Sale channel ID", example = "1") Long id) {
        saleChannelService.deleteSaleChannel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
