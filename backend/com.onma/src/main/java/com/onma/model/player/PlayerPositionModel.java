package com.onma.model.player;

import com.onma.model.base.AbstractModel;
import com.onma.model.enums.PlayerPositionEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "player_position")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class PlayerPositionModel extends AbstractModel {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PlayerPositionEnum position;
}
