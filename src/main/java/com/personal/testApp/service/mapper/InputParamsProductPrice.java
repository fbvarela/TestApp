package com.personal.testApp.service.mapper;

import lombok.Builder;

@Builder
public record InputParamsProductPrice(String starDate, int productId, int brandId) {
}

