package com.onma.form.team.tactic;

import com.onma.form.base.AbstractForm;
import com.onma.form.team.TeamForm;
import com.onma.model.enums.FormationEnum;
import com.onma.model.team.TeamModel;
import com.onma.model.team.tactic.TacticModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class TacticForm extends AbstractForm {

    @NotNull
    private Long teamId;

    @NotNull
    private String formation;

    @NotNull
    @Valid
    private ApproachForm approach;

    @NotNull
    private Boolean active;

    public static TacticModel convert(final TacticForm tacticForm) {
        return TacticModel.builder().
                id(tacticForm.getId()).
                formation(FormationEnum.valueOf(tacticForm.formation)).
                approach(ApproachForm.convert(tacticForm.approach)).
                active(tacticForm.active).
                build();
    }

}
