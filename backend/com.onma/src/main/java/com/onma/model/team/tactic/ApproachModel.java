package com.onma.model.team.tactic;

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
@Table(name = "approach")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class ApproachModel extends AbstractModel {

    @Column
    @Min(1)
    @Max(99)
    private Long teamWidth;

    @Column
    @Min(1)
    @Max(99)
    private Long teamDepth;

    @Column
    @Min(1)
    @Max(99)
    private Long pressing;

}
