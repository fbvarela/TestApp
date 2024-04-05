package com.personal.testApp.service;

import com.personal.testApp.service.dto.InputParamsProductPriceDTO;
import com.personal.testApp.service.dto.ProductPriceDTO;
import com.personal.testApp.service.helper.DateValidation;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GetProductPriceByDateAndProductIdAndBrandId implements GetProductPriceByDateAndProductIdAndBrandIdUseCase  {

    private final ProductPriceService repository;

    public GetProductPriceByDateAndProductIdAndBrandId(final ProductPriceService repository) {
        this.repository = repository;
    }

    @Override
    public List<ProductPriceDTO> execute(final InputParamsProductPriceDTO inputProductPriceDTO) {
        List<ProductPriceDTO> productPrices = this.repository.execute(inputProductPriceDTO);

        return productPrices.stream()
            .map(product -> product.withIsApplicable(
                DateValidation.isDateBetween(inputProductPriceDTO.date(), product.getStartDate(),
                product.getEndDate())))
            .map(product -> product.withDate(inputProductPriceDTO.date()))
            .filter(product -> product.isDiscountApplicable())
            .toList();
    }
}



