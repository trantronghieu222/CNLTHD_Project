package com.shop.watch.repository;

import com.shop.watch.model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierModel, Integer> {
}
