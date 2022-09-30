package com.alper.couponear.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private String mail;
    private String token;
}
