package com.personal.testApp.service;

import com.personal.testApp.service.dto.InputParamsProductPriceDTO;
import com.personal.testApp.service.dto.ProductPriceDTO;
import java.util.List;

public interface ProductPriceService {
    List<ProductPriceDTO> execute(final InputParamsProductPriceDTO productPrice);
}
