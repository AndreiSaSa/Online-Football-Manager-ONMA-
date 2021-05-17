package com.onma.form.team;

import com.onma.form.base.AbstractForm;
import com.onma.model.team.TeamInformationModel;
import com.onma.model.team.TeamModel;
import com.onma.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class TeamForm extends AbstractForm {

    @NotNull
    private Long userId;

    @Valid
    private TeamInformationForm teamInformation;

    public static TeamModel convert(final TeamForm teamForm) {
        return TeamModel.builder().
                id(teamForm.getId()).
                teamInformation(TeamInformationForm.convert(teamForm.teamInformation)).
                build();
    }

}
