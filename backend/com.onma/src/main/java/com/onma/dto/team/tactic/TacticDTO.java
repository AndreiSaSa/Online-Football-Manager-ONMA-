package com.onma.dto.team.tactic;

import com.onma.dto.base.AbstractDTO;
import com.onma.dto.team.TeamDTO;
import com.onma.model.team.tactic.TacticModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class TacticDTO extends AbstractDTO {

    private TeamDTO team;
    private String formation;
    private ApproachDTO approach;
    private Boolean active;

    public static TacticDTO convert(final TacticModel tacticModel) {
        return TacticDTO.builder().
                id(tacticModel.getId()).
                team(TeamDTO.convert(tacticModel.getTeam())).
                formation(tacticModel.getFormation().toString()).
                approach(ApproachDTO.convert(tacticModel.getApproach())).
                active(tacticModel.getActive()).
                build();
    }

}
