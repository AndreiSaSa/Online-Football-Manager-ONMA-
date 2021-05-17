package com.onma.form.match;

import com.onma.form.base.AbstractForm;
import com.onma.model.competition.CompetitionModel;
import com.onma.model.match.MatchModel;
import com.onma.model.team.TeamModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class MatchForm extends AbstractForm {

    @NotNull
    private Long homeTeamId;

    @NotNull
    private Long awayTeamId;

    @NotNull
    private Long competitionId;

    @NotNull
    private Long matchDay;

    private boolean played;

    private MatchDataForm matchData;

    public static MatchModel convert(final MatchForm matchForm) {
        return MatchModel.builder().
                id(matchForm.getId()).
                homeTeam(TeamModel.builder().id(matchForm.homeTeamId).build()).
                awayTeam(TeamModel.builder().id(matchForm.awayTeamId).build()).
                competition(CompetitionModel.builder().id(matchForm.competitionId).build()).
                matchDay(matchForm.matchDay).
                matchData(MatchDataForm.convert(matchForm.matchData)).
                played(matchForm.played).
                build();
    }

}
