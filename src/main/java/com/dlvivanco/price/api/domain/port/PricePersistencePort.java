package com.dlvivanco.price.api.domain.port;


import com.dlvivanco.price.api.domain.model.Price;

import java.time.LocalDateTime;

public interface PricePersistencePort {
    
    Price findByApplicationDateBrandIdAndProductId(LocalDateTime applicationDate, Integer brandId, Integer productId);

}
