package com.onma.dto.match;

import com.onma.dto.base.AbstractDTO;
import com.onma.dto.competition.CompetitionDTO;
import com.onma.dto.team.TeamDTO;
import com.onma.model.match.MatchModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class MatchDTO extends AbstractDTO {
    
    private TeamDTO homeTeam;
    private TeamDTO awayTeam;
    private CompetitionDTO competition;
    private MatchDataDTO matchData;
    private Long matchDay;
    private Boolean played;

    public static MatchDTO convert(final MatchModel matchModel) {
        return MatchDTO.builder().
                id(matchModel.getId()).
                homeTeam(TeamDTO.convert(matchModel.getHomeTeam())).
                awayTeam(TeamDTO.convert(matchModel.getAwayTeam())).
                competition(CompetitionDTO.convert(matchModel.getCompetition())).
                matchDay(matchModel.getMatchDay()).
                played(matchModel.getPlayed()).
                matchData(MatchDataDTO.convert(matchModel.getMatchData())).
                build();
    }

}
