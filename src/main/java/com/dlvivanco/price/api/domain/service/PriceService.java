package com.dlvivanco.price.api.domain.service;

import com.dlvivanco.price.api.domain.exception.PriceNotFoundException;
import com.dlvivanco.price.api.domain.exception.ProductNotFoundException;
import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.domain.port.PricePersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService {
    
    private final PricePersistencePort pricePersistencePort;
    
    public Price findByApplicationDateBrandIdAndProductId(LocalDateTime applicationDate, Integer brandId, Integer productId) {
        List<Price> prices =  this.pricePersistencePort.findByBrandIdAndProductId(brandId, productId);

        if(prices.isEmpty()) {
            throw new ProductNotFoundException("the product " + productId + " for the brand " + brandId + " was not found");
        }
        return prices.stream()
                .filter(p -> applicationDate.isAfter(p.getStartDate()) && applicationDate.isBefore(p.getEndDate()))
                .max(Comparator.comparing(Price::getPriority))
                .orElseThrow( () -> new PriceNotFoundException("the price of the product was not found on the requested date " + applicationDate));
    }
}
