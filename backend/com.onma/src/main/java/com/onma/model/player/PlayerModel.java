package com.onma.model.player;

import com.onma.model.base.AbstractModel;
import com.onma.model.team.TeamModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "player")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class PlayerModel extends AbstractModel {

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    private Long number;

    @Column(nullable = false)
    private Long estimatedPrice;

    @Column(nullable = false)
    private Long wage;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private PlayerAttributesModel playerAttributes;

    @Column(nullable = false)
    private Boolean transferListed;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "player_preferred_position",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "preferred_position_id")
    )
    @NotNull
    private List<PlayerPositionModel> preferredPositions;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private TeamModel team;

    @Column(nullable = false)
    private Long tacticPosition;

}
