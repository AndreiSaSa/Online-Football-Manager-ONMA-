package com.onma.model.player;

import com.onma.model.base.AbstractModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "player_attributes")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class PlayerAttributesModel extends AbstractModel {

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
}
