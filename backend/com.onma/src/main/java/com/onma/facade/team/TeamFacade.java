package com.onma.facade.team;

import com.onma.dto.team.TeamDTO;
import com.onma.facade.base.AbstractFacade;
import com.onma.form.team.TeamForm;

public interface TeamFacade extends AbstractFacade<TeamDTO, TeamForm> {
    void selectTeam(final Long teamId);
}
