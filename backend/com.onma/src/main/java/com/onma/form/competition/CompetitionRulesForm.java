package com.onma.form.competition;

import com.onma.form.base.AbstractForm;
import com.onma.model.competition.CompetitionRulesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CompetitionRulesForm extends AbstractForm {

    private Long numberOfTeams;

    private Long numberOfGames;

    public static CompetitionRulesModel convert(final CompetitionRulesForm competitionRulesForm) {
        return CompetitionRulesModel.builder().
                id(competitionRulesForm.getId()).
                numberOfTeams(competitionRulesForm.numberOfTeams).
                numberOfGames(competitionRulesForm.numberOfGames).
                build();
    }

}
