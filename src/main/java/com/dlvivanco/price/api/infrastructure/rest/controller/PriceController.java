package com.dlvivanco.price.api.infrastructure.rest.controller;

import com.dlvivanco.price.api.application.GetPriceByFilterUseCase;
import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.infrastructure.rest.dto.PriceDto;
import com.dlvivanco.price.api.infrastructure.rest.dto.PriceFilterDto;
import com.dlvivanco.price.api.infrastructure.rest.mapper.PriceDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Validated
public class PriceController {
    
    private final GetPriceByFilterUseCase getPriceByFilterUseCase;

    private final PriceDtoMapper priceDtoMapper;
    
    @Operation(summary = "Get a price by application date, brand id and product id. " +
            "If there is more than one, the one with the highest priority is returned.")
    @GetMapping("/price")
    public PriceDto getPriceByApplicationDateBrandIdAndProductId(@Valid PriceFilterDto priceFilterDto) {
        final Price price = this.getPriceByFilterUseCase.getPriceByFilter(
                priceFilterDto.getApplicationDate(), 
                priceFilterDto.getBrandId(), 
                priceFilterDto.getProductId());
        
        return priceDtoMapper.toDto(price);
    }
}
