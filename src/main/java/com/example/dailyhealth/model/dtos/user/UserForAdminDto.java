package com.example.dailyhealth.model.dtos.user;

import com.example.dailyhealth.registration.appuser.AppUserRole;

public class UserForAdminDto {
    private String username;
    private String role;

    public UserForAdminDto() {
    }

    public String getUsername() {
        return username;
    }

    public UserForAdminDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRole() {
        return role;
    }

    public UserForAdminDto setRole(String role) {
        this.role = role;
        return this;
    }
}
