package com.onma.dto.player;

import com.onma.dto.base.AbstractDTO;
import com.onma.dto.team.TeamDTO;
import com.onma.model.player.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class PlayerDTO extends AbstractDTO {

    private String name;
    private Long number;
    private Long estimatedPrice;
    private Long wage;
    private PlayerAttributesDTO playerAttributes;
    private Boolean transferListed;
    private TeamDTO team;
    private Long tacticPosition;

    public static PlayerDTO convert(final PlayerModel playerModel) {
        return PlayerDTO.builder().
                id(playerModel.getId()).
                name(playerModel.getName()).
                number(playerModel.getNumber()).
                estimatedPrice(playerModel.getEstimatedPrice()).
                wage(playerModel.getWage()).
                playerAttributes(PlayerAttributesDTO.convert(playerModel.getPlayerAttributes())).
                transferListed(playerModel.getTransferListed()).
                team(TeamDTO.convert(playerModel.getTeam())).
                tacticPosition(playerModel.getTacticPosition()).
                build();
    }

}
