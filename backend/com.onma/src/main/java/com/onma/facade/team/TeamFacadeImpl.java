package com.onma.facade.team;

import com.onma.dto.team.TeamDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.team.TeamForm;
import com.onma.model.team.TeamModel;
import com.onma.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class TeamFacadeImpl extends AbstractFacadeImpl<TeamModel, TeamDTO, TeamForm> implements TeamFacade {

    private final UserService userService;

    @Override
    protected TeamDTO convertModelToDTO(final TeamModel teamModel) {
        return TeamDTO.convert(teamModel);
    }

    @Override
    protected TeamModel convertFormToModel(final TeamForm teamForm) {
        final TeamModel teamModel = TeamForm.convert(teamForm);
        teamModel.setUser(userService.getById(teamForm.getUserId()));
        return teamModel;
    }
}
