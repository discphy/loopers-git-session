package com.loopers.domain.user;

import lombok.Getter;

@Getter
public class User {

    private Long id;

    private String username;

    private String password;

    private UserRole role;

    public User(String name, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("회원 이름이 올바르지 않습니다.");
        }

        if (password == null || password.length() < 10) {
            throw new IllegalArgumentException("비밀번호는 최소 10자 이상이어야 합니다.");
        }

        this.username = name;
        this.password = password;
        this.role = UserRole.UNKNOWN;
    }
}
