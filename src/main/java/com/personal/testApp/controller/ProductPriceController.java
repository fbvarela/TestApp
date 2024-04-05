package com.personal.testApp.controller;

import com.personal.testApp.service.GetProductPriceByDateAndProductIdAndBrandId;
import com.personal.testApp.service.GetProductPriceByDateAndProductIdAndBrandIdUseCase;
import com.personal.testApp.service.dto.InputParamsProductPriceDTO;
import com.personal.testApp.service.dto.ProductPriceDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Validated
public class ProductPriceController {

    private final GetProductPriceByDateAndProductIdAndBrandIdUseCase service;

    @GetMapping("/productPrices")
    public ResponseEntity<List<ProductPriceDTO>> getProductPrice(
        @RequestParam @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}-\\d{2}\\.\\d{2}\\.\\d{2}$",
            message = "Date format: 'yyyy-MM-dd-HH.mm.ss'") String date,
        @RequestParam Integer productId,
        @RequestParam Integer brandId) {

        var inputParamsProductPriceDTO =
            InputParamsProductPriceDTO.builder()
                .date(date)
                .productId(productId)
                .brandId(brandId)
                .build();

        return ResponseEntity.ok(this.service.execute(inputParamsProductPriceDTO));
    }
}