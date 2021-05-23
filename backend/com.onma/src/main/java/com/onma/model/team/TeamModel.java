package com.onma.model.team;

import com.onma.model.base.AbstractModel;
import com.onma.model.match.MatchModel;
import com.onma.model.player.PlayerModel;
import com.onma.model.team.tactic.TacticModel;
import com.onma.model.user.UserModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "team")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class TeamModel extends AbstractModel {

    @ManyToOne(fetch = FetchType.EAGER)
    private UserModel user;

    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @NotNull
    private TeamInformationModel teamInformation;

    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PlayerModel> players;

    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TacticModel> tactics;
}
