package com.example.dailyhealth.model.dtos.user;

import com.example.dailyhealth.registration.appuser.AppUserRole;

public class RoleChangeDto {
    private String username;
    private AppUserRole role;


    public String getUsername() {
        return username;
    }

    public RoleChangeDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public AppUserRole getRole() {
        return role;
    }

    public RoleChangeDto setRole(AppUserRole role) {
        this.role = role;
        return this;
    }
}
