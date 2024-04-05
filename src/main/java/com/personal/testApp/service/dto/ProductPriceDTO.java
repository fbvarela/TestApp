package com.personal.testApp.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Builder(toBuilder = true)
@Data
public class ProductPriceDTO {

  private Integer productId;
  private Integer brandId;

  @JsonIgnore
  private String date;

  private final String startDate;
  private String endDate;
  private String price;

  @JsonIgnore
  private boolean isDiscountApplicable;

  public ProductPriceDTO withIsApplicable (boolean isBetween) {
    return this.toBuilder()
        .isDiscountApplicable(isBetween)
        .build();
  }

  public ProductPriceDTO withDate (String date) {
    return this.toBuilder()
        .date(date)
        .build();
  }
}