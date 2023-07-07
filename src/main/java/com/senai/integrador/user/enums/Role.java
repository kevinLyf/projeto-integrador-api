package com.senai.integrador.user.enums;

public enum Role {

    ADMIN("admin"),
    USER("admin");

    private String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
