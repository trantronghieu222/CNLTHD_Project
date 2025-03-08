package com.shop.watch.controller;

import com.shop.watch.model.AccountModel;
import com.shop.watch.service.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Api/User")
@Tag(name = "Users")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    private List<AccountModel> getAllUser(){
        return accountService.getAllUser();
    }

    @GetMapping("/{id}")
    private ResponseEntity<AccountModel> getUserById(@RequestParam Integer id){
        AccountModel accountModel = accountService.getUserById(id);
        return ResponseEntity.ok(accountModel);
    }

    @GetMapping("/search")
    private ResponseEntity<List<AccountModel>> findUserByName(@RequestParam String name){
        List<AccountModel> accounts = accountService.getUserByName(name);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/search-paging")
    public ResponseEntity<Map<String, Object>> searchAccounts(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "1") int pageIndex,
            @RequestParam(defaultValue = "10") int pageSize
    ) {
        Page<AccountModel> page = accountService.searchAccounts(keyword, pageIndex, pageSize);

        Map<String, Object> response = new HashMap<>();
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());
        response.put("currentPage", pageIndex);
        response.put("content", page.getContent());

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<AccountModel> createUser(@RequestBody AccountModel accountModel){
        AccountModel accountCreated = accountService.createUser(accountModel);
        return ResponseEntity.ok(accountCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountModel> updateUser(@RequestParam Integer id, @RequestBody AccountModel accountModel){
        AccountModel accountUpdated = accountService.updateUser(id, accountModel);
        return ResponseEntity.ok(accountUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@RequestParam Integer id){
        accountService.deteteUser(id);
        return ResponseEntity.noContent().build();
    }
}
