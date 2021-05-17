package com.onma.form.player;

import com.onma.form.base.AbstractForm;
import com.onma.model.enums.PlayerPositionEnum;
import com.onma.model.player.PlayerPositionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
public class PlayerPositionForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String position;

    public static PlayerPositionModel convert(final PlayerPositionForm playerPositionForm) {
        return PlayerPositionModel.builder().
                id(playerPositionForm.getId()).
                position(PlayerPositionEnum.valueOf(playerPositionForm.position)).
                build();
    }

}
