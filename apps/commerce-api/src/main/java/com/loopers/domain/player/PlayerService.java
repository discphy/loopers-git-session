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

    /**
     * 플레이어 권한을 가지고 있는 회원에 한해 팀을 배정합니다.
     * - 팀이 배정되지 않은 플레이어 권한을 가진 회원만 팀 배정이 가능합니다.
     * - 팀 배정을 완료한 플레이어를 생성 및 저장 후 반환합니다.
     *
     * @param user 팀이 배정되지 않은 플레이어 권한을 가진 회원
     * @param team 배정될 팀
     * @return 팀이 배정된 플레이어
     */
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

    /**
     * 플레이어가 과제 패스 시 마다 패스 횟수를 1 증가시킵니다.
     *  - 플레이어가 존재하지 않을 경우 예외를 발생시킵니다.
     *
     * @param playerId 패스를 시도하는 플레이어의 ID
     */
    public void pass(Long playerId) {
        Player player = playerRepository.findById(playerId)
            .orElseThrow(() -> new RuntimeException("존재하지 않는 플레이어입니다."));

        player.setPassCount(player.getPassCount() + 1);
        playerRepository.save(player);
    }
}
