package com.onma.dto.match;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.match.MatchDataModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class MatchDataDTO extends AbstractDTO {
    
    private Long homeScore;
    private Long awayScore;

    public static MatchDataDTO convert(final MatchDataModel matchDataModel) {
        if(matchDataModel == null) {
            return null;
        }
        return MatchDataDTO.builder().
                id(matchDataModel.getId()).
                homeScore(matchDataModel.getHomeScore()).
                awayScore(matchDataModel.getAwayScore()).
                build();
    }

}
