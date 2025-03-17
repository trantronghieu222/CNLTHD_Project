package com.shop.authservice.service;

import com.shop.authservice.dto.request.RefreshTokenDTO;
import com.shop.authservice.dto.request.LoginDTO;
import com.shop.authservice.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse login(LoginDTO loginDTO);

    AuthResponse refreshToken(RefreshTokenDTO refreshToken);
}