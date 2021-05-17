package com.onma.model.team.tactic;

import com.onma.model.base.AbstractModel;
import com.onma.model.enums.FormationEnum;
import com.onma.model.team.TeamModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tactic")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class TacticModel extends AbstractModel {

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private TeamModel team;

    @Column
    @NotNull
    @Enumerated(EnumType.STRING)
    private FormationEnum formation;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private ApproachModel approach;

    @Column(nullable = false)
    private Boolean active;

}
