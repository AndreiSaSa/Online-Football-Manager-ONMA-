package com.onma.form.competition;

import com.onma.form.base.AbstractForm;
import com.onma.model.competition.CompetitionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
public class CompetitionForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String name;

    @Valid
    private CompetitionRulesForm competitionRules;

    private Long matchDay;

    public static CompetitionModel convert(final CompetitionForm competitionForm) {
        return CompetitionModel.builder().
                id(competitionForm.getId()).
                name(competitionForm.getName()).
                matchDay(competitionForm.matchDay).
                competitionRules(CompetitionRulesForm.convert(competitionForm.competitionRules)).
                build();
    }

}
