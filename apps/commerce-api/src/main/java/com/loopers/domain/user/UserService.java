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

        userRepository.save(new User(name, password));
    }
}
