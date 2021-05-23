package com.onma.facade.team;

import com.onma.dto.team.TeamDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.team.TeamForm;
import com.onma.model.team.TeamModel;
import com.onma.model.user.UserModel;
import com.onma.service.team.TeamService;
import com.onma.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class TeamFacadeImpl extends AbstractFacadeImpl<TeamModel, TeamDTO, TeamForm> implements TeamFacade {

    private final UserService userService;
    private final TeamService teamService;

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

    @Override
    public void selectTeam(final Long teamId) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Long currentPrincipalId = ((UserModel) authentication.getPrincipal()).getId();
        final UserModel userModel = userService.getById(currentPrincipalId);

        final TeamModel teamModel = teamService.getById(teamId);
        teamModel.setUser(userModel);
        teamService.saveOrUpdate(teamModel);
    }
}
