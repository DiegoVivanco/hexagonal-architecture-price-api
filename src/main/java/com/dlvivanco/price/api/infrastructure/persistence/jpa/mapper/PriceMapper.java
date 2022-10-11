package com.dlvivanco.price.api.infrastructure.persistence.jpa.mapper;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.infrastructure.persistence.jpa.entity.PriceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PriceMapper {
    
    public PriceEntity toEntity(Price project){
        if(project == null){
            return null;
        }
        
        PriceEntity.PriceEntityBuilder projectEntity = PriceEntity.builder();
        
        projectEntity.id(project.getId());
        projectEntity.brandId(project.getBrandId());
        projectEntity.startDate(project.getStartDate());
        projectEntity.endDate(project.getEndDate());
        projectEntity.priceList(project.getPriceList());
        projectEntity.productId(project.getProductId());
        projectEntity.priority(project.getPriority());
        projectEntity.price(project.getPrice());
        projectEntity.currency(project.getCurrency());
        projectEntity.lastUpdate(project.getLastUpdate());
        projectEntity.lastUpdateBy(project.getLastUpdateBy());
        
        return projectEntity.build();
    }

    public Price toDto(PriceEntity projectEntity){
        if(projectEntity == null){
            return null;
        }

        Price.PriceBuilder project = Price.builder();

        project.id(projectEntity.getId());
        project.brandId(projectEntity.getBrandId());
        project.startDate(projectEntity.getStartDate());
        project.endDate(projectEntity.getEndDate());
        project.priceList(projectEntity.getPriceList());
        project.productId(projectEntity.getProductId());
        project.priority(projectEntity.getPriority());
        project.price(projectEntity.getPrice());
        project.currency(projectEntity.getCurrency());
        project.lastUpdate(projectEntity.getLastUpdate());
        project.lastUpdateBy(projectEntity.getLastUpdateBy());

        return project.build();
    }
}
