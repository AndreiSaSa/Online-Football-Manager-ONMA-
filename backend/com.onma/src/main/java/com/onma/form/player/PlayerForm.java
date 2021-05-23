package com.onma.form.player;

import com.onma.form.base.AbstractForm;
import com.onma.model.player.PlayerModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class PlayerForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Long number;

    @NotNull
    private Long estimatedPrice;

    @NotNull
    private Long wage;

    @Valid
    private PlayerAttributesForm playerAttributes;

    @NotNull
    private Boolean transferListed;

    @NotNull
    private Long teamId;

    @NotNull
    private Long tacticPosition;

    public static PlayerModel convert(final PlayerForm playerForm) {
        return PlayerModel.builder().
                id(playerForm.getId()).
                name(playerForm.name).
                number(playerForm.number).
                estimatedPrice(playerForm.estimatedPrice).
                wage(playerForm.wage).
                playerAttributes(PlayerAttributesForm.convert(playerForm.playerAttributes)).
                transferListed(playerForm.transferListed).
                tacticPosition(playerForm.tacticPosition).
                build();
    }

}
