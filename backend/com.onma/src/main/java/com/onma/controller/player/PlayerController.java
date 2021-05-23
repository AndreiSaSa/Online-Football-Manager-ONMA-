package com.onma.controller.player;

import com.onma.controller.base.AbstractController;
import com.onma.dto.player.PlayerDTO;
import com.onma.facade.player.PlayerFacade;
import com.onma.form.player.PlayerForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController extends AbstractController<PlayerDTO, PlayerForm> {

    private final PlayerFacade playerFacade;

    @PostMapping("/{playerId}/transfer-list")
    public void transferList(@PathVariable @Valid final Long playerId) {
        playerFacade.transferList(playerId);
    }

    @PostMapping("/{playerId}/buy/{teamId}")
    public void buy(@PathVariable final Long playerId, @PathVariable final Long teamId) {
        playerFacade.buy(playerId, teamId);
    }

    @GetMapping("/market")
    public List<PlayerDTO> getAllTransferLister() {
        return playerFacade.getAllTransferListed();
    }

}
