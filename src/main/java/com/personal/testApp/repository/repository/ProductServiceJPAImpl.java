package com.personal.testApp.repository.repository;

import com.personal.testApp.repository.mapper.ProductPriceMapper;
import com.personal.testApp.service.dto.InputParamsProductPriceDTO;
import com.personal.testApp.service.dto.ProductPriceDTO;
import com.personal.testApp.service.ProductPriceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ProductServiceJPAImpl implements ProductPriceService {

    private final ProductPriceCustomRepository repository;
    private final ProductPriceMapper productPriceMapper;

    @Override
    public List<ProductPriceDTO> execute(final InputParamsProductPriceDTO productPrice) {
        return this.productPriceMapper
            .toDTOs(this.repository.findProductPriceByProductIdAndBrandId(productPrice.productId(), productPrice.brandId()));
    }
}
