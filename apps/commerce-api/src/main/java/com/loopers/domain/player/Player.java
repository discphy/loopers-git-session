package com.loopers.domain.player;

import com.loopers.domain.team.Team;
import com.loopers.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Player {

    private User user;

    private Team team;

    @Setter
    private int passCount;

    public Player(User user, Team team) {
        this.user = user;
        this.team = team;
    }

}
