package com.onma.form.team.tactic;

import com.onma.form.base.AbstractForm;
import com.onma.model.team.tactic.ApproachModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class ApproachForm extends AbstractForm {

    @Column
    @Min(1)
    @Max(99)
    private Long teamWidth;

    @Column
    @Min(1)
    @Max(99)
    private Long teamDepth;

    @Column
    @Min(1)
    @Max(99)
    private Long pressing;

    public static ApproachModel convert(final ApproachForm approachForm) {
        return ApproachModel.builder().
                id(approachForm.getId()).
                teamWidth(approachForm.teamWidth).
                teamDepth(approachForm.teamDepth).
                pressing(approachForm.pressing).
                build();
    }

}
