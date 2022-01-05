package com.banksystem.models;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.banksystem.models.AppUserPermissoin.USER_READ;
import static com.banksystem.models.AppUserPermissoin.USER_WRITE;

public enum AppUserRole {
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE)),
    USER(Sets.newHashSet(USER_READ));

    private final Set<AppUserPermissoin> permissions;

    AppUserRole(Set<AppUserPermissoin> permissions) {
        this.permissions = permissions;
    }
}
