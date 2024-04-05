package com.personal.testApp.repository.repository;

import com.personal.testApp.repository.entitiy.ProductPrice;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ProductPriceCustomRepository extends CrudRepository<ProductPrice, Long> {
    List<ProductPrice> findProductPriceByProductIdAndBrandId(int productId, int brandId);
}
