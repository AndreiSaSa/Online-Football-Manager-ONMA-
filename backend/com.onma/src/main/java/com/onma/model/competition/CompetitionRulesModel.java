package com.onma.model.competition;

import com.onma.model.base.AbstractModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Table(name = "competition_rules")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class CompetitionRulesModel extends AbstractModel {

    @Column(nullable = false)
    @NotBlank
    private LocalDateTime startTime;

    @Column(nullable = false)
    @NotBlank
    private LocalDateTime endTime;

    @Column(nullable = false)
    @NotBlank
    private LocalDateTime nextMatchTime;

    @Column(nullable = false)
    @NotBlank
    private Long numberOfTeams;

    @Column(nullable = false)
    @NotBlank
    private Long numberOfGames;
}
