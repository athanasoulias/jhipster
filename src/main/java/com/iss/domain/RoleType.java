package com.iss.domain;

import java.util.Arrays;

public enum RoleType {
    ROLE_ADMIN("Administrator"),
    STAFF("Staff");

    private final String roleDescription;

    RoleType(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleDescription() {
        return this.roleDescription;
    }

    public static RoleType fromDescription(String roleDescription) {
        return Arrays.stream(values()).filter(r -> r.getRoleDescription().equals(roleDescription)).findAny().orElse(null);
    }
}
