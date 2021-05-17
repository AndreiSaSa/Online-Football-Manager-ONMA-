package com.onma.dto.team;

import com.onma.dto.base.AbstractDTO;
import com.onma.dto.user.UserDTO;
import com.onma.model.team.TeamModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class TeamDTO extends AbstractDTO {

    private UserDTO user;
    private TeamInformationDTO teamInformation;

    public static TeamDTO convert(final TeamModel teamModel) {
        return TeamDTO.builder().
                id(teamModel.getId()).
                user(UserDTO.convert(teamModel.getUser())).
                teamInformation(TeamInformationDTO.convert(teamModel.getTeamInformation())).
                build();
    }

}
