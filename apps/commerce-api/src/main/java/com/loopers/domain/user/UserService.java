package com.loopers.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(String name, String password) {
        userRepository.findByName(name).ifPresent(u -> {
            throw new IllegalArgumentException("이미 존재하는 회원 이름입니다.");
        });

        if (name == null) {
            throw new IllegalArgumentException("회원 이름이 올바르지 않습니다.");
        }

        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상이어야 합니다.");
        }

        User user = new User(name, password);
        userRepository.save(user);
    }
}
