package com.onma.dto.player;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.player.PlayerPositionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class PlayerPositionDTO extends AbstractDTO {

    private String position;

    public static PlayerPositionDTO convert(final PlayerPositionModel playerPositionModel) {
        return PlayerPositionDTO.builder().
                id(playerPositionModel.getId()).
                position(playerPositionModel.getPosition().toString()).
                build();
    }

}
