package com.loopers.domain.user;

import lombok.Getter;

@Getter
public class User {

    private Long id;

    private String username;

    private UserRole role;
}
