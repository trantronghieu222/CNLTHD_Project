package com.shop.watch.repository;

import com.shop.watch.model.AccountModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepository extends JpaRepository<AccountModel, Integer> {
    List<AccountModel> findByIsDeletedFalseAndCustomerNameContainingIgnoreCase(String customerName);

    Page<AccountModel> findByCustomerNameContainingIgnoreCaseAndIsDeletedFalse(String customerName, Pageable pageable);

    AccountModel findByUsernameContainingIgnoreCase(String username);
}
