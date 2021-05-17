package com.onma.dto.player;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.player.PlayerAttributesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class PlayerAttributesDTO extends AbstractDTO {
    
    private Long gk;
    private Long def;
    private Long mid;
    private Long att;
    private Long speed;
    private Long physical;

    public static PlayerAttributesDTO convert(final PlayerAttributesModel playerAttributesModel) {
        return PlayerAttributesDTO.builder().
                id(playerAttributesModel.getId()).
                gk(playerAttributesModel.getGk()).
                def(playerAttributesModel.getDef()).
                mid(playerAttributesModel.getMid()).
                att(playerAttributesModel.getAtt()).
                speed(playerAttributesModel.getSpeed()).
                physical(playerAttributesModel.getPhysical()).
                build();
    }

}
