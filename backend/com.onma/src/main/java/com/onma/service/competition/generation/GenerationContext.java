package com.onma.service.competition.generation;

import com.onma.model.competition.CompetitionModel;

public class GenerationContext {

    private GenerationStrategy generationStrategy;

    public GenerationContext(final GenerationStrategy generationStrategy) {
        this.generationStrategy = generationStrategy;
    }

    public void executeStrategy(final CompetitionModel competitionModel) {
        generationStrategy.generateCompetition(competitionModel);
    }
}
