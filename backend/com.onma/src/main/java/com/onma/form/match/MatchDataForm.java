package com.onma.form.match;

import com.onma.form.base.AbstractForm;
import com.onma.model.match.MatchDataModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class MatchDataForm extends AbstractForm {

    @NotNull
    private Long homeScore;

    @NotNull
    private Long awayScore;

    public static MatchDataModel convert(final MatchDataForm matchDataForm) {
        return MatchDataModel.builder().
                id(matchDataForm.getId()).
                homeScore(matchDataForm.homeScore).
                awayScore(matchDataForm.awayScore).
                build();
    }

}
