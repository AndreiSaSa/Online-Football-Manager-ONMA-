package com.onma.facade.competition;

import com.onma.dto.competition.CompetitionDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.competition.CompetitionForm;
import com.onma.model.competition.CompetitionModel;
import com.onma.service.competition.CompetitionService;
import com.onma.service.competition.generation.GenerationContext;
import com.onma.service.competition.generation.GenerationEqual;
import com.onma.service.competition.generation.GenerationRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CompetitionFacadeImpl extends AbstractFacadeImpl<CompetitionModel, CompetitionDTO, CompetitionForm> implements CompetitionFacade {

    private final GenerationEqual generationEqual;
    private final GenerationRandom generationRandom;
    private final CompetitionService competitionService;

    @Override
    protected CompetitionDTO convertModelToDTO(final CompetitionModel competitionModel) {
        return CompetitionDTO.convert(competitionModel);
    }

    @Override
    protected CompetitionModel convertFormToModel(final CompetitionForm competitionForm) {
        return CompetitionForm.convert(competitionForm);
    }

    @Override
    public void generateEqual(final CompetitionForm competitionForm) {
        final CompetitionModel competitionModel = convertFormToModel(competitionForm);
        competitionModel.setMatchDay(1L);
        final GenerationContext generationContext = new GenerationContext(generationEqual);
        generationContext.executeStrategy(competitionModel);
    }

    @Override
    public void generateRandom(final CompetitionForm competitionForm) {
        final CompetitionModel competitionModel = convertFormToModel(competitionForm);
        competitionModel.setMatchDay(1L);
        final GenerationContext generationContext = new GenerationContext(generationRandom);
        generationContext.executeStrategy(competitionModel);
    }

    @Override
    public void advanceMatchDay(final Long competitionId) {
        final CompetitionModel competitionModel = competitionService.getById(competitionId);
        competitionService.advanceMatchDay(competitionModel);
    }
}
