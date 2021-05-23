package com.onma.facade.team.tactic;

import com.onma.dto.team.tactic.TacticDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.team.tactic.TacticForm;
import com.onma.model.team.tactic.TacticModel;
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
public class TacticFacadeImpl extends AbstractFacadeImpl<TacticModel, TacticDTO, TacticForm> implements TacticFacade {

    private final TeamService teamService;
    private final UserService userService;

    @Override
    protected TacticDTO convertModelToDTO(final TacticModel tacticModel) {
        return TacticDTO.convert(tacticModel);
    }

    @Override
    protected TacticModel convertFormToModel(final TacticForm tacticForm) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Long currentPrincipalId = ((UserModel) authentication.getPrincipal()).getId();
        final UserModel userModel = userService.getById(currentPrincipalId);

        final TacticModel tacticModel = TacticForm.convert(tacticForm);
        tacticModel.setTeam(teamService.getById(tacticForm.getTeamId()));

        if(!tacticModel.getTeam().getUser().getId().equals(userModel.getId())) {
            throw new RuntimeException("Team does not correspond to current user");
        }

        return tacticModel;
    }
}
