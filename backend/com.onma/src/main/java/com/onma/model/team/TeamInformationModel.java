package com.onma.model.team;

import com.onma.model.base.AbstractModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "team_information")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class TeamInformationModel extends AbstractModel {

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(nullable = false)
    @NotBlank
    private Long transferBudget;

    @Column(nullable = false)
    @NotBlank
    private Long wageBudget;

}
