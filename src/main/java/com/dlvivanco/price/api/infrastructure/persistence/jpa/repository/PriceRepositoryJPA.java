package com.dlvivanco.price.api.infrastructure.persistence.jpa.repository;

import com.dlvivanco.price.api.infrastructure.persistence.jpa.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepositoryJPA extends JpaRepository<PriceEntity, Integer> {
    
    List<PriceEntity> findByBrandIdAndProductId(Integer brandId, Integer productId);

}
