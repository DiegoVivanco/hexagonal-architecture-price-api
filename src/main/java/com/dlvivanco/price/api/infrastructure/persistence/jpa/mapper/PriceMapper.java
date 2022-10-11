package com.dlvivanco.price.api.infrastructure.persistence.jpa.mapper;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.entity.PriceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceMapper {

    public Price toDto(PriceEntity priceEntity){
        if(priceEntity == null){
            return null;
        }

        Price.PriceBuilder price = Price.builder();

        price.brandId(priceEntity.getBrandId());
        price.startDate(priceEntity.getStartDate());
        price.endDate(priceEntity.getEndDate());
        price.priceList(priceEntity.getPriceList());
        price.productId(priceEntity.getProductId());
        price.price(priceEntity.getPrice());

        return price.build();
    }
}
