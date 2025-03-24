package com.shop.watch.service;

import com.shop.watch.model.AccountModel;
import com.shop.watch.model.PermissionModel;
import com.shop.watch.repository.AccountRepository;
import com.shop.watch.repository.PermissionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    public List<AccountModel> getAllUser(){
        return accountRepository.findAll();
    }

    public AccountModel getUserById(Integer id){
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<AccountModel> getUserByName(String name){
        return accountRepository.findByIsDeletedFalseAndCustomerNameContainingIgnoreCase(name);
    }

    public Page<AccountModel> searchAccounts(String keyword, int pageIndex, int pageSize) {
        Pageable pageable = PageRequest.of(pageIndex - 1, pageSize); // `pageIndex` bắt đầu từ 1
        return accountRepository.findByCustomerNameContainingIgnoreCaseAndIsDeletedFalse(keyword, pageable);
    }

    public AccountModel createUser(AccountModel accountModel){
        PermissionModel permission = permissionRepository.findById(accountModel.getPermission().getPermissionId()).orElseThrow(()-> new RuntimeException("Permission not found"));
        accountModel.setPermission(permission);
        return accountRepository.save(accountModel);
    }

    public AccountModel updateUser(Integer id, AccountModel accountModel){
        AccountModel accountUpdated = getUserById(id);
//        accountUpdated.setUsername(accountModel.getUsername());
//        accountUpdated.setPassword(accountModel.getPassword());
//        accountUpdated.setCustomerEmail(accountModel.getCustomerEmail());
//        accountUpdated.setCustomerAddress(accountModel.getCustomerAddress());
//        accountUpdated.setCustomerName(accountModel.getCustomerName());
//        accountUpdated.setPermission(accountModel.getPermission());
//        accountUpdated.setCustomerPhone(accountModel.getCustomerPhone());
//        accountUpdated.setDeleted(accountModel.getDeleted());

        //  cách ngắn hơn
        BeanUtils.copyProperties(accountModel, accountUpdated, "id");
        return accountRepository.save(accountModel);
    }

    public void deteteUser(Integer id){
        accountRepository.deleteById(id);
    }
}
