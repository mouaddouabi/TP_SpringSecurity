package com.banksystem.models;

public enum AppUserPermissoin {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    AppUserPermissoin(String permission) {
        this.permission = permission;
    }
}
