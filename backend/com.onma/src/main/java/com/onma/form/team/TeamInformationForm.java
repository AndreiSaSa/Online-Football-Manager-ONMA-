package com.onma.form.team;

import com.onma.form.base.AbstractForm;
import com.onma.model.team.TeamInformationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class TeamInformationForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Long transferBudget;

    @NotNull
    private Long wageBudget;

    public static TeamInformationModel convert(final TeamInformationForm teamInformationForm) {
        return TeamInformationModel.builder().
                id(teamInformationForm.getId()).
                name(teamInformationForm.name).
                transferBudget(teamInformationForm.transferBudget).
                wageBudget(teamInformationForm.wageBudget).
                build();
    }

}
