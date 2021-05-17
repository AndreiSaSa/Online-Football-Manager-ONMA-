package com.onma.form.player;

import com.onma.form.base.AbstractForm;
import com.onma.model.player.PlayerAttributesModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class PlayerAttributesForm extends AbstractForm {

    @Column
    @Min(1)
    @Max(99)
    private Long gk;

    @Column
    @Min(1)
    @Max(99)
    private Long def;

    @Column
    @Min(1)
    @Max(99)
    private Long mid;

    @Column
    @Min(1)
    @Max(99)
    private Long att;

    @Column
    @Min(1)
    @Max(99)
    private Long speed;

    @Column
    @Min(1)
    @Max(99)
    private Long physical;

    public static PlayerAttributesModel convert(final PlayerAttributesForm playerAttributesForm) {
        return PlayerAttributesModel.builder().
                id(playerAttributesForm.getId()).
                gk(playerAttributesForm.gk).
                def(playerAttributesForm.def).
                mid(playerAttributesForm.mid).
                att(playerAttributesForm.att).
                speed(playerAttributesForm.speed).
                physical(playerAttributesForm.physical).
                build();
    }

}
