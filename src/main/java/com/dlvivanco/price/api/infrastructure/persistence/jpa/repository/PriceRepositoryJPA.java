package com.dlvivanco.price.api.infrastructure.persistence.jpa.repository;

import com.dlvivanco.price.api.infrastructure.persistence.jpa.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryJPA extends JpaRepository<PriceEntity, Integer> {
    
    @Query("SELECT p FROM PriceEntity p WHERE"
            + " (:applicationDate BETWEEN p.startDate AND p.endDate)"
            + " AND (:brandId =  p.brandId)"
            + " AND (:productId =  p.productId)"
            + " ORDER BY p.priority DESC"
    )
    List<PriceEntity> findByApplicationDateBrandIdAndProductId(LocalDateTime applicationDate, Integer brandId, Integer productId);
}
