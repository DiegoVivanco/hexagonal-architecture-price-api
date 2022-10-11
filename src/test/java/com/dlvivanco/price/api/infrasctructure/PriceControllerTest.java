package com.dlvivanco.price.api.infrasctructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class PriceControllerTest {

    private static final int BRAND_ZARA_CODE = 1;

    private static final String PRODUCT_ID = "35455";
    private static final String PRODUCT_ID_JSON_PATH = "$.productId";
    private static final String BRAND_ID_JSON_PATH = "$.brandId";
    private static final String PRICE_JSON_PATH = "$.price";

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void givenADate20200614T100000_whenFindByBrandIdProductIdBetweenDates_thenReturnAPriceWithHigherPriority() throws Exception {
        this.mockMvc.perform(get("/price")
                        .param("applicationDate","2020-06-14-10:00:00")
                        .param("productId","35455")
                        .param("brandId","1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(PRODUCT_ID_JSON_PATH).value(PRODUCT_ID))
                .andExpect(MockMvcResultMatchers.jsonPath(BRAND_ID_JSON_PATH).value(BRAND_ZARA_CODE))
                .andExpect(MockMvcResultMatchers.jsonPath(PRICE_JSON_PATH).value(35.5));

    }

    @Test
    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void givenADate20200614T160000_whenFindByBrandIdProductIdBetweenDates_thenReturnAPriceWithHigherPriority() throws Exception {
        this.mockMvc.perform(get("/price")
                        .param("applicationDate","2020-06-14-16:00:00")
                        .param("productId","35455")
                        .param("brandId","1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(PRODUCT_ID_JSON_PATH).value(PRODUCT_ID))
                .andExpect(MockMvcResultMatchers.jsonPath(BRAND_ID_JSON_PATH).value(BRAND_ZARA_CODE))
                .andExpect(MockMvcResultMatchers.jsonPath(PRICE_JSON_PATH).value(25.45));
    }

    @Test
    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
    public void givenADate20200614T210000_whenFindByBrandIdProductIdBetweenDates_thenReturnAPriceWithHigherPriority() throws Exception {
        this.mockMvc.perform(get("/price")
                        .param("applicationDate","2020-06-14-21:00:00")
                        .param("productId","35455")
                        .param("brandId","1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(PRODUCT_ID_JSON_PATH).value(PRODUCT_ID))
                .andExpect(MockMvcResultMatchers.jsonPath(BRAND_ID_JSON_PATH).value(BRAND_ZARA_CODE))
                .andExpect(MockMvcResultMatchers.jsonPath(PRICE_JSON_PATH).value(35.5));
    }

    @Test
    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)")
    public void givenADate20200615T100000_whenFindByBrandIdProductIdBetweenDates_thenReturnAPriceWithHigherPriority() throws Exception {
        this.mockMvc.perform(get("/price")
                        .param("applicationDate","2020-06-15-10:00:00")
                        .param("productId","35455")
                        .param("brandId","1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(PRODUCT_ID_JSON_PATH).value(PRODUCT_ID))
                .andExpect(MockMvcResultMatchers.jsonPath(BRAND_ID_JSON_PATH).value(BRAND_ZARA_CODE))
                .andExpect(MockMvcResultMatchers.jsonPath(PRICE_JSON_PATH).value(30.5));
    }

    @Test
    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
    public void givenADate20200616T210000_whenFindByBrandIdProductIdBetweenDates_thenReturnAPriceWithHigherPriority() throws Exception {
        this.mockMvc.perform(get("/price")
                        .param("applicationDate","2020-06-16-21:00:00")
                        .param("productId","35455")
                        .param("brandId","1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andExpect(MockMvcResultMatchers.jsonPath(PRODUCT_ID_JSON_PATH).value(PRODUCT_ID))
                .andExpect(MockMvcResultMatchers.jsonPath(BRAND_ID_JSON_PATH).value(BRAND_ZARA_CODE))
                .andExpect(MockMvcResultMatchers.jsonPath(PRICE_JSON_PATH).value(38.95));
    }

    @Test
    @DisplayName("Test 6: BadRequest cuando no se le pasa un parámetro obligatorio")
    public void givenABadRequest_whenRequiredParameterIsNotSent() throws Exception {
        this.mockMvc.perform(get("/price?applicationDate=2020-06-16-21:00:00&productId=35455"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Test 7: Not Found cuando no se le pasa un brandId diferente de 1")
    public void givenANotFound_whenBrandIdNotEqualsTo1() throws Exception {
        this.mockMvc.perform(get("/price?applicationDate=2020-06-16-21:00:00&productId=35455&brandId=5"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
