package com.loopers.domain.player;

import java.util.Optional;

public interface PlayerRepository {

    Player save(Player player);

    Optional<Player> findById(Long id);

    Optional<Player> findByUserId(Long userId);
}
