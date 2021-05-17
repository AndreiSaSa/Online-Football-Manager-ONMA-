package com.onma.model.match;

import com.onma.model.base.AbstractModel;
import com.onma.model.competition.CompetitionModel;
import com.onma.model.team.TeamModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "match_game")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class MatchModel extends AbstractModel {

    @ManyToOne(fetch = FetchType.LAZY)
    private TeamModel homeTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    private TeamModel awayTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    private CompetitionModel competition;

    @Column(nullable = false)
    private Long matchDay;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private MatchDataModel matchData;

    @Column(nullable = false)
    private Boolean played;

}
