package com.loopers.domain.user;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum UserRole {

    MENTOR("멘토"),
    MANAGER("매니저"),
    ANGEL("엔젤"),
    PLAYER("플레이어"),
    ;

    private final String description;
}
