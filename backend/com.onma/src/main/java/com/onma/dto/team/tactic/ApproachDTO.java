package com.onma.dto.team.tactic;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.team.tactic.ApproachModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class ApproachDTO extends AbstractDTO {

    private Long teamWidth;
    private Long teamDepth;
    private Long pressing;

    public static ApproachDTO convert(final ApproachModel approachModel) {
        return ApproachDTO.builder().
                id(approachModel.getId()).
                teamWidth(approachModel.getTeamWidth()).
                teamDepth(approachModel.getTeamDepth()).
                pressing(approachModel.getPressing()).
                build();
    }

}
