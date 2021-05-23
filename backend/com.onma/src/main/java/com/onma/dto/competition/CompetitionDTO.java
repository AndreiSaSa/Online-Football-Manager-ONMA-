package com.onma.dto.competition;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.competition.CompetitionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CompetitionDTO extends AbstractDTO {
    
    private String name;
    private CompetitionRulesDTO competitionRules;
    private Long matchDay;

    public static CompetitionDTO convert(final CompetitionModel competitionModel) {
        return CompetitionDTO.builder().
                id(competitionModel.getId()).
                name(competitionModel.getName()).
                matchDay(competitionModel.getMatchDay()).
                competitionRules(CompetitionRulesDTO.convert(competitionModel.getCompetitionRules())).
                build();
    }

}
