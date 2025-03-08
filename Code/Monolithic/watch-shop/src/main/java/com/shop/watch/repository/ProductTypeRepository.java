package com.shop.watch.repository;

import com.shop.watch.model.ProductTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductTypeRepository extends JpaRepository<ProductTypeModel, Integer> {
}
