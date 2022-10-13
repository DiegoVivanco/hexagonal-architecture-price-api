package com.dlvivanco.price.api.infrastructure.persistence.jpa.adapter;

import com.dlvivanco.price.api.domain.exception.PriceNotFoundException;
import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.domain.port.PricePersistencePort;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.entity.PriceEntity;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.mapper.PriceMapper;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.repository.PriceRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapterJPA implements PricePersistencePort {
   
    private final PriceMapper priceMapper;
    private final PriceRepositoryJPA priceRepositoryJPA;
    
    @Override
    public Price findByApplicationDateBrandIdAndProductId(LocalDateTime applicationDate, Integer brandId, Integer productId) {
        List<PriceEntity> priceEntity = 
                this.priceRepositoryJPA.findByBrandIdAndProductId(brandId, productId);
        
        return this.priceMapper.toDto(priceEntity.stream()
                .filter(p -> applicationDate.isAfter(p.getStartDate()) && applicationDate.isBefore(p.getEndDate()))
                .max(Comparator.comparing(PriceEntity::getPriority))
                .orElseThrow( () -> new PriceNotFoundException("the price of the product " + productId + " for the brand " + brandId +
                " was not found on the requested date " + applicationDate)));
    }
    
}
