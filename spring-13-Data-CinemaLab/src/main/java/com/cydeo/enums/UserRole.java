package com.cydeo.enums;

public enum UserRole {

    REGULAR_USERS("Regular Users"),
    ADMIN_USERS("Admin Users");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
