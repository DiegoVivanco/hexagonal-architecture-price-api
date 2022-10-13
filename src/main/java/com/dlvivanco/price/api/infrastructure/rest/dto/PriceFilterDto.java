package com.dlvivanco.price.api.infrastructure.rest.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class PriceFilterDto {

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm:ss")
    private LocalDateTime applicationDate;
    @NotNull
    private Integer brandId;
    @NotNull
    private Integer productId;

}