package com.shop.watch.controller;

import com.shop.watch.dto.request.SignUp;
import com.shop.watch.model.AccountModel;
import com.shop.watch.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api/Auth")
@Tag(name = "Auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/SignUp")
    public ResponseEntity<AccountModel> signUp(@RequestBody SignUp signUp){
        AccountModel accountModel = authService.signUp(signUp);
        return ResponseEntity.ok(accountModel);
    }
}
