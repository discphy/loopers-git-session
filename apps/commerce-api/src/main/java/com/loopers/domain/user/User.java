package com.loopers.domain.user;

import lombok.Getter;

@Getter
public class User {

    private Long id;

    private String username;

    private String password;

    private UserRole role;

    public User(String name, String password) {
        this.username = name;
        this.password = password;
        this.role = UserRole.UNKNOWN;
    }
}
