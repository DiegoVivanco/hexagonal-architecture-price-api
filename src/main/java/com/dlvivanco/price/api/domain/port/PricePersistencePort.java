package com.dlvivanco.price.api.domain.port;


import com.dlvivanco.price.api.domain.model.Price;

import java.util.List;

public interface PricePersistencePort {
    
    List<Price> findByBrandIdAndProductId(Integer brandId, Integer productId);

}
