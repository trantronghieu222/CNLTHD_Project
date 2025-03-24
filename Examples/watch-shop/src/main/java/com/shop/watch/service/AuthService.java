package com.shop.watch.service;

import com.shop.watch.dto.request.SignUp;
import com.shop.watch.model.AccountModel;
import com.shop.watch.model.PermissionModel;
import com.shop.watch.repository.AccountRepository;
import com.shop.watch.repository.AuthRepository;
import com.shop.watch.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public AccountModel signUp(SignUp signUp){
        AccountModel accountModel = new AccountModel();
        accountModel.setUsername(signUp.getUsername());
        accountModel.setPassword((signUp.getPassword()));
        accountModel.setCustomerName(signUp.getCustomerName());
        accountModel.setCustomerPhone(signUp.getCustomerPhone());
        accountModel.setCustomerEmail(signUp.getCustomerEmail());

        Optional<PermissionModel> permissionOptional = permissionRepository.findById(1);
        if (permissionOptional.isPresent()) {
            accountModel.setPermission(permissionOptional.get());
        } else {
            throw new RuntimeException("Product type not found with id: 1");
        }

        return authRepository.save(accountModel);
    }
}
