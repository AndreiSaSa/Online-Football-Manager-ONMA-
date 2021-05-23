package com.onma.service.competition.generation;

import com.onma.model.competition.CompetitionModel;

public interface GenerationStrategy {
    void generateCompetition(final CompetitionModel competitionModel);
}
