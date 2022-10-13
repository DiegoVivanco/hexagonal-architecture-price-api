package com.dlvivanco.price.api.infrastructure.rest.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PriceDto {
    
    private Integer productId;

    private Integer brandId;

    private Integer priceList;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Double price;
    
}
