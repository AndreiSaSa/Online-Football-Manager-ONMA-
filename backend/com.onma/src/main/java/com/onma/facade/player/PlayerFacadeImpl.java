package com.onma.facade.player;

import com.onma.config.ConstantsConfig;
import com.onma.dto.player.PlayerDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.player.PlayerForm;
import com.onma.model.player.PlayerModel;
import com.onma.model.team.TeamInformationModel;
import com.onma.model.team.TeamModel;
import com.onma.model.user.UserModel;
import com.onma.service.player.PlayerService;
import com.onma.service.team.TeamService;
import com.onma.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
@RequiredArgsConstructor
public class PlayerFacadeImpl extends AbstractFacadeImpl<PlayerModel, PlayerDTO, PlayerForm> implements PlayerFacade {

    private final TeamService teamService;
    private final PlayerService playerService;
    private final UserService userService;

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

    @Override
    public void transferList(final Long playerId) {
        final PlayerModel playerModel = playerService.getById(playerId);
        playerModel.setTransferListed(true);

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Long currentPrincipalId = ((UserModel) authentication.getPrincipal()).getId();
        final UserModel userModel = userService.getById(currentPrincipalId);

        if(!playerModel.getTeam().getUser().getId().equals(userModel.getId())) {
            throw new RuntimeException("Player does not correspond to current user");
        }
        playerService.saveOrUpdate(playerModel);
    }

    @Override
    public List<PlayerDTO> getAllTransferListed() {
        final List<PlayerModel> playerModels = playerService.getAllTransferListed();
        return playerModels.stream().map(this::convertModelToDTO).collect(Collectors.toList());
    }

    @Override
    public void buy(final Long playerId, final Long teamId) {
        final PlayerModel playerModel = playerService.getById(playerId);

        if(!playerModel.getTransferListed()) {
            throw new RuntimeException(ConstantsConfig.NOT_LISTED);
        }

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final Long currentPrincipalId = ((UserModel) authentication.getPrincipal()).getId();
        final UserModel userModel = userService.getById(currentPrincipalId);

        final TeamModel teamModel = teamService.getById(teamId);
        if(!teamModel.getUser().getId().equals(userModel.getId())) {
            throw new RuntimeException(ConstantsConfig.NOT_CURRENT_USER);
        }

        if(playerModel.getTeam().getUser().getId().equals(userModel.getId())) {
            throw new RuntimeException(ConstantsConfig.OWN_TEAM);
        }

        final TeamInformationModel teamInformationModel = teamModel.getTeamInformation();
        final Long budget = teamInformationModel.getTransferBudget();
        final Long wage = teamInformationModel.getWageBudget();
        if(budget < playerModel.getEstimatedPrice() || wage < playerModel.getWage()) {
            throw new RuntimeException(ConstantsConfig.NOT_ENOUGH_BUDGET);
        }
        teamInformationModel.setTransferBudget(budget - playerModel.getEstimatedPrice());
        teamInformationModel.setWageBudget(wage - playerModel.getWage());
        teamService.saveOrUpdate(teamModel);

        final TeamModel currentTeam = playerModel.getTeam();
        final TeamInformationModel currentTeamInformation = currentTeam.getTeamInformation();
        currentTeamInformation.setWageBudget(currentTeamInformation.getWageBudget() + playerModel.getWage());
        currentTeamInformation.setTransferBudget(currentTeamInformation.getTransferBudget() + playerModel.getEstimatedPrice());
        teamService.saveOrUpdate(currentTeam);

        playerModel.setTeam(teamModel);
        playerModel.setTransferListed(false);
        playerService.saveOrUpdateTransfer(playerModel, currentTeam, teamModel);
    }
}
