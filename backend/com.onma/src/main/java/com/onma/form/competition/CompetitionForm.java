package com.onma.form.competition;

import com.onma.form.base.AbstractForm;
import com.onma.model.competition.CompetitionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class CompetitionForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String name;

    @Valid
    @NotNull
    private CompetitionRulesForm competitionRules;

    public static CompetitionModel convert(final CompetitionForm competitionForm) {
        return CompetitionModel.builder().
                id(competitionForm.getId()).
                name(competitionForm.getName()).
                competitionRules(CompetitionRulesForm.convert(competitionForm.competitionRules)).
                build();
    }

}
