package com.onma.form.competition;

import com.onma.form.base.AbstractForm;
import com.onma.model.competition.CompetitionRulesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
public class CompetitionRulesForm extends AbstractForm {

    @Min(0)
    @Max(20)
    private Long numberOfTeams;

    public static CompetitionRulesModel convert(final CompetitionRulesForm competitionRulesForm) {
        return CompetitionRulesModel.builder().
                id(competitionRulesForm.getId()).
                numberOfTeams(competitionRulesForm.numberOfTeams).
                build();
    }

}
