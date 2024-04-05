package com.personal.testApp.repository.repository;

import com.personal.testApp.repository.entitiy.ProductPrice;
import org.springframework.data.repository.CrudRepository;

public interface ProductPriceJPARepository extends CrudRepository<ProductPrice, Long> {
}
