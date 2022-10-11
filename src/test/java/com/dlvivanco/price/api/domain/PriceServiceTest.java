package com.dlvivanco.price.api.domain;

import com.dlvivanco.price.api.domain.model.Price;
import com.dlvivanco.price.api.domain.port.PricePersistencePort;
import com.dlvivanco.price.api.domain.service.PriceService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PriceServiceTest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");

    @Mock
    private PricePersistencePort mockRepository;

    @InjectMocks
    private PriceService priceService;

    private static Price price1, price2, price3, price4;

    @BeforeAll
    public static void setup() {
        price1 = new Price(35455,1, 1, LocalDateTime.parse("2020-06-14-00.00.00",formatter),
                LocalDateTime.parse("2020-12-31-23.59.59",formatter),35.5);

        price2 = new Price(35455,1,2, LocalDateTime.parse("2020-06-14-15.00.00",formatter),
                LocalDateTime.parse("2020-06-14-18.30.00",formatter),25.45);

        price3 = new Price(35455,1,3, LocalDateTime.parse("2020-06-15-00.00.00",formatter),
                LocalDateTime.parse("2020-06-15-11.00.00",formatter),30.5);

        price4 = new Price(35455,1,4, LocalDateTime.parse("2020-06-15-16.00.00",formatter),
                LocalDateTime.parse("2020-12-31-23.59.59",formatter),38.95);
    }

    @Test
    public void test01__2020_06_14_1000_brandId_1_productId_35455() {
        Mockito.when(mockRepository.findByApplicationDateBrandIdAndProductId(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(price1);
        Price result = priceService.findByApplicationDateBrandIdAndProductId(
                LocalDateTime.parse("2020-06-14-10.00.00",formatter),1,35455);
        assertEquals(1,result.getPriceList());
    }

    @Test
    public void test02__2020_06_14_1600_brandId_1_productId_35455() {
        Mockito.when(mockRepository.findByApplicationDateBrandIdAndProductId(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(price2);
        Price result = priceService.findByApplicationDateBrandIdAndProductId(
                LocalDateTime.parse("2020-06-14-16.00.00",formatter),1,35455);
        assertEquals(2,result.getPriceList());
    }

    @Test
    public void test03__2020_06_14_2100_brandId_1_productId_35455() {
        Mockito.when(mockRepository.findByApplicationDateBrandIdAndProductId(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(price1);
        Price result = priceService.findByApplicationDateBrandIdAndProductId(
                LocalDateTime.parse("2020-06-14-21.00.00",formatter),1,35455);
        assertEquals(1,result.getPriceList());
    }

    @Test
    public void test04__2020_06_15_1000_brandId_1_productId_35455() {
        Mockito.when(mockRepository.findByApplicationDateBrandIdAndProductId(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(price3);
        Price result = priceService.findByApplicationDateBrandIdAndProductId(
                LocalDateTime.parse("2020-06-15-10.00.00",formatter),1,35455);
        assertEquals(3,result.getPriceList());
    }

    @Test
    public void test05__2020_06_16_2100_brandId_1_productId_35455() {
        Mockito.when(mockRepository.findByApplicationDateBrandIdAndProductId(Mockito.any(),Mockito.any(),Mockito.any())).thenReturn(price4);
        Price result = priceService.findByApplicationDateBrandIdAndProductId(
                LocalDateTime.parse("2020-06-16-21.00.00",formatter),1,35455);
        assertEquals(4,result.getPriceList());
    }
}
