package com.personal.testApp.service.dto;

import lombok.Builder;

@Builder
public record InputParamsProductPriceDTO(
   String date,
   int productId,
   int brandId
) {}
