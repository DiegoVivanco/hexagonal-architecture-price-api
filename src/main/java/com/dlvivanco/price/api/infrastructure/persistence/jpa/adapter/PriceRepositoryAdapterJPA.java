package com.dlvivanco.price.api.infrastructure.persistence.jpa.adapter;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.domain.port.PricePersistencePort;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.entity.PriceEntity;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.mapper.PriceMapper;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.repository.PriceRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PriceRepositoryAdapterJPA implements PricePersistencePort {
   
    private final PriceRepositoryJPA priceRepositoryJPA;
    
    @Override
    public List<Price> findByBrandIdAndProductId(Integer brandId, Integer productId) {
        List<PriceEntity> priceEntities = 
                this.priceRepositoryJPA.findByBrandIdAndProductId(brandId, productId);
        
        return priceEntities.stream().map(PriceMapper::toDomain).collect(Collectors.toList());
    }
    
}
