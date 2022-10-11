package com.dlvivanco.price.api.application;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.domain.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class GetPriceByFilterUseCase {
    
    private final PriceService priceService;

    public Price getPriceByFilter(LocalDateTime applicationDate, Integer brandId, Integer productId) {
        return priceService.findByApplicationDateBrandIdAndProductId(applicationDate,brandId,productId);
    }
}
