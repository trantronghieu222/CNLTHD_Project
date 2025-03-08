package com.shop.watch.repository;

import com.shop.watch.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AccountModel, Integer> {
}
