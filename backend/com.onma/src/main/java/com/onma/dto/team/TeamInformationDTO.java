package com.onma.dto.team;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.team.TeamInformationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class TeamInformationDTO extends AbstractDTO {

    private String name;
    private Long transferBudget;
    private Long wageBudget;

    public static TeamInformationDTO convert(final TeamInformationModel teamInformationModel) {
        return TeamInformationDTO.builder().
                id(teamInformationModel.getId()).
                name(teamInformationModel.getName()).
                transferBudget(teamInformationModel.getTransferBudget()).
                wageBudget(teamInformationModel.getWageBudget()).
                build();
    }

}
