package com.personal.testApp.service;

import com.personal.testApp.service.dto.InputParamsProductPriceDTO;
import com.personal.testApp.service.dto.ProductPriceDTO;
import java.util.List;

public interface GetProductPriceByDateAndProductIdAndBrandIdUseCase {
  List<ProductPriceDTO> execute(final InputParamsProductPriceDTO productPriceDTO);
}
