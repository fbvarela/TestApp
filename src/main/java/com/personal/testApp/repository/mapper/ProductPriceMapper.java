package com.personal.testApp.repository.mapper;

import com.personal.testApp.repository.entitiy.ProductPrice;
import com.personal.testApp.service.dto.ProductPriceDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductPriceMapper {

    public List<ProductPriceDTO> toDTOs(final List<ProductPrice> productPrices) {
        return productPrices.stream()
            .map(this::toDTO)
            .toList();
    }

    private ProductPriceDTO toDTO (final ProductPrice productPrice) {
        return ProductPriceDTO.builder()
            .productId(productPrice.getProductId())
            .brandId(productPrice.getBrandId())
            .startDate(productPrice.getStartDate())
            .endDate((productPrice.getEndDate()))
            .price(productPrice.getPrice())
            .build();
    }
}
