package com.onma.dto.competition;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.competition.CompetitionRulesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CompetitionRulesDTO extends AbstractDTO {

    private Long numberOfTeams;
    private Long numberOfGames;

    public static CompetitionRulesDTO convert(final CompetitionRulesModel competitionRulesModel) {
        return CompetitionRulesDTO.builder().
                id(competitionRulesModel.getId()).
                numberOfGames(competitionRulesModel.getNumberOfGames()).
                numberOfTeams(competitionRulesModel.getNumberOfTeams()).
                build();
    }

}
