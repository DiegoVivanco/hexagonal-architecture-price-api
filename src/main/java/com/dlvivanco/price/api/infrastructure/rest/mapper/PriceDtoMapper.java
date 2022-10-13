package com.dlvivanco.price.api.infrastructure.rest.mapper;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.infrastructure.rest.dto.PriceDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceDtoMapper {

    public PriceDto toDto(Price price){
        if(price == null){
            return null;
        }

        PriceDto.PriceDtoBuilder priceDto = PriceDto.builder();

        priceDto.brandId(price.getBrandId());
        priceDto.startDate(price.getStartDate());
        priceDto.endDate(price.getEndDate());
        priceDto.priceList(price.getPriceList());
        priceDto.productId(price.getProductId());
        priceDto.price(price.getPrice());

        return priceDto.build();
    }
}
