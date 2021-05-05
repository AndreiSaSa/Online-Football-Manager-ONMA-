package com.onma.model.competition;

import com.onma.model.base.AbstractModel;
import com.onma.model.match.MatchModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "competition")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class CompetitionModel extends AbstractModel {

    @Column(nullable = false)
    @NotBlank
    private String name;

    @OneToMany(
            mappedBy = "competition",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<MatchModel> matches;

    @OneToOne(fetch = FetchType.LAZY)
    private CompetitionRulesModel competitionRules;

}
