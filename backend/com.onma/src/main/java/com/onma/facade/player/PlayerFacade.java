package com.onma.facade.player;

import com.onma.dto.player.PlayerDTO;
import com.onma.facade.base.AbstractFacade;
import com.onma.form.player.PlayerForm;

import java.util.List;

public interface PlayerFacade extends AbstractFacade<PlayerDTO, PlayerForm> {
    void transferList(final Long playerId);
    List<PlayerDTO> getAllTransferListed();
    void buy(final Long playerId, final Long teamId);
}
