package com.onma.facade.player;

import com.onma.dto.player.PlayerDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.player.PlayerForm;
import com.onma.model.player.PlayerModel;
import com.onma.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class PlayerFacadeImpl extends AbstractFacadeImpl<PlayerModel, PlayerDTO, PlayerForm> implements PlayerFacade {

    private final TeamService teamService;

    @Override
    protected PlayerDTO convertModelToDTO(final PlayerModel playerModel) {
        return PlayerDTO.convert(playerModel);
    }

    @Override
    protected PlayerModel convertFormToModel(final PlayerForm playerForm) {
        final PlayerModel playerModel = PlayerForm.convert(playerForm);
        playerModel.setTeam(teamService.getById(playerForm.getTeamId()));
        return playerModel;
    }
}
