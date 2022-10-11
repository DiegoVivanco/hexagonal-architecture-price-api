package com.dlvivanco.price.api.domain.service;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.domain.port.PricePersistencePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService {
    
    private final PricePersistencePort pricePersistencePort;
    
    public Price findByApplicationDateBrandIdAndProductId(LocalDateTime applicationDate, Integer brandId, Integer productId) {
        return this.pricePersistencePort.findByApplicationDateBrandIdAndProductId(applicationDate, brandId, productId);
    }
}
