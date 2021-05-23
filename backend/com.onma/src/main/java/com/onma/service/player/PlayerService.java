package com.onma.service.player;

import com.onma.model.player.PlayerModel;
import com.onma.model.team.TeamModel;
import com.onma.service.base.AbstractService;

import java.util.List;

public interface PlayerService extends AbstractService<PlayerModel> {
    List<PlayerModel> getAllTransferListed();
    void saveOrUpdateTransfer(final PlayerModel playerModel, final TeamModel from, final TeamModel to);
}
