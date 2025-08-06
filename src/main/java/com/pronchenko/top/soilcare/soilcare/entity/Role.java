package com.pronchenko.top.soilcare.soilcare.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,    // Обычный пользователь
    SELLER,  // Продавец удобрений
    ADMIN;   // Администратор

    @Override
    public String getAuthority() {
        return "ROLE_" + name();
    }
}
