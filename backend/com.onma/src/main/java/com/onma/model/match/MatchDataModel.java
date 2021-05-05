package com.onma.model.match;

import com.onma.model.base.AbstractModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "match_data")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class MatchDataModel extends AbstractModel {

    @Column
    private Long homeScore;

    @Column
    private Long awayScore;
}
