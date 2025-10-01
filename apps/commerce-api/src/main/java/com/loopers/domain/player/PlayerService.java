package com.loopers.domain.player;

import com.loopers.domain.team.Team;
import com.loopers.domain.user.User;
import com.loopers.domain.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player selectTeam(User user, Team team) {
        playerRepository.findByUserId(user.getId()).ifPresent(p -> {
            throw new IllegalStateException("이미 팀이 배정된 플레이어입니다.");
        });

        if (user.getRole() != UserRole.PLAYER) {
            throw new IllegalStateException("플레이어가 아닌 회원은 팀 배정이 불가합니다.");
        }

        Player player = new Player(user, team);
        return playerRepository.save(player);
    }
}
