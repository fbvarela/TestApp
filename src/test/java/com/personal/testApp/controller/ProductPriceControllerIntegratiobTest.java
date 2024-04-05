package com.personal.testApp.controller;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.personal.testApp.service.GetProductPriceByDateAndProductIdAndBrandId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class ProductPriceControllerIntegratiobTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("Testing case 1: date: 2020-06-14-10.00.00, productId: 35455 and brandId: 1 ")
  void whenCcase1ThenReturnProduct() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-14-10.00.00")
            .param("productId", "35455")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].productId").value(35455))
        .andExpect(jsonPath("$[0].brandId").value(1))
        .andExpect(jsonPath("$[0].startDate").value("2020-06-14-00.00.00"))
        .andExpect(jsonPath("$[0].price").value("35.50"));
  }

  @Test
  @DisplayName("Testing case 2: date: 2020-06-14-16.00.00, productId: 35455 and brandId: 1 ")
  void whenCase2ThenReturnProduct() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-14-16.00.00")
            .param("productId", "35455")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].productId").value(35455))
        .andExpect(jsonPath("$[0].brandId").value(1))
        .andExpect(jsonPath("$[0].startDate").value("2020-06-14-00.00.00"))
        .andExpect(jsonPath("$[0].price").value("35.50"))
        .andExpect(jsonPath("$[1].productId").value(35455))
        .andExpect(jsonPath("$[1].brandId").value(1))
        .andExpect(jsonPath("$[1].startDate").value("2020-06-14-15.00.00"))
        .andExpect(jsonPath("$[1].price").value("25.45"));
  }

  @Test
  @DisplayName("Testing case 3: date: 2020-06-14-21.00.00, productId: 35455 and brandId: 1 ")
  void whenCase3ThenReturnProduct() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-14-21.00.00")
            .param("productId", "35455")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].productId").value(35455))
        .andExpect(jsonPath("$[0].brandId").value(1))
        .andExpect(jsonPath("$[0].startDate").value("2020-06-14-00.00.00"))
        .andExpect(jsonPath("$[0].price").value("35.50"));
  }

  @Test
  @DisplayName("Testing case 4: date: 2020-06-15-10.00.00, productId: 35455 and brandId: 1 ")
  void whenCase4ThenReturnProduct() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-15-10.00.00")
            .param("productId", "35455")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].productId").value(35455))
        .andExpect(jsonPath("$[0].brandId").value(1))
        .andExpect(jsonPath("$[0].startDate").value("2020-06-14-00.00.00"))
        .andExpect(jsonPath("$[0].price").value("35.50"))
        .andExpect(jsonPath("$[1].productId").value(35455))
        .andExpect(jsonPath("$[1].brandId").value(1))
        .andExpect(jsonPath("$[1].startDate").value("2020-06-15-00.00.00"))
        .andExpect(jsonPath("$[1].price").value("30.50"));
  }

  @Test
  @DisplayName("Testing case 5: date: 2020-06-16-21.00.00, productId: 35455 and brandId: 1 ")
  void whenCase5ThenReturnProduct() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-16-21.00.00")
            .param("productId", "35455")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].productId").value(35455))
        .andExpect(jsonPath("$[0].brandId").value(1))
        .andExpect(jsonPath("$[0].startDate").value("2020-06-14-00.00.00"))
        .andExpect(jsonPath("$[0].price").value("35.50"))
        .andExpect(jsonPath("$[1].productId").value(35455))
        .andExpect(jsonPath("$[1].brandId").value(1))
        .andExpect(jsonPath("$[1].startDate").value("2020-06-15-16.00.00"))
        .andExpect(jsonPath("$[1].price").value("38.95"));
  }

  @Test
  @DisplayName("When date param have an icorrect format, return an error object ")
  void whenDateWithIncorrectReturnErrorMessage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020/06/16 21:00:00")
            .param("productId", "35455")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Invalid request"))
        .andExpect(jsonPath("$.description").value("Date format: 'yyyy-MM-dd-HH.mm.ss'"));
  }

  @Test
  @DisplayName("When productId is blank, return an error object ")
  void whenBlankProductIdReturnErrorMessage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-16-21.00.00")
            .param("productId", "")
            .param("brandId", "1")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Invalid request"))
        .andExpect(jsonPath("$.description").value("Required request parameter 'productId' for method parameter type Integer is present but converted to null"));
  }

  @Test
  @DisplayName("When brandId is blank, return an error object ")
  void whenBlankBrandIdReturnErrorMessage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/api/productPrices")
            .param("date", "2020-06-16-21.00.00")
            .param("productId", "1")
            .param("brandId", "")
            .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.message").value("Invalid request"))
        .andExpect(jsonPath("$.description").value("Required request parameter 'brandId' for method parameter type Integer is present but converted to null"));
  }
}