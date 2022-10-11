package com.dlvivanco.price.api.infrastructure.rest.controller;

import com.dlvivanco.price.api.application.GetPriceByFilterUseCase;
import com.dlvivanco.price.api.domain.model.Price;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class PriceController {
    
    private final GetPriceByFilterUseCase getPriceByFilterUseCase;

    @Operation(summary = "Get a price by application date, brand id and product id. " +
            "If there is more than one, the one with the highest priority is returned.")
    @GetMapping("/price")
    public Price getPriceByApplicationDateBrandIdAndProductId(
            @Parameter(description = "Application date for the price. Format: yyyy-MM-dd-HH.mm.ss")
            @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss") @RequestParam LocalDateTime applicationDate,
            @Parameter(description = "Id of the product's brand. An integer.") @RequestParam  Integer brandId,
            @Parameter(description = "Id of the product. An integer.")@RequestParam  Integer productId) {
        return this.getPriceByFilterUseCase.getPriceByFilter(applicationDate, brandId, productId);
    }
}
