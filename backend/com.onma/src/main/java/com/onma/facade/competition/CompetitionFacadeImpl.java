package com.onma.facade.competition;

import com.onma.dto.competition.CompetitionDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.competition.CompetitionForm;
import com.onma.model.competition.CompetitionModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class CompetitionFacadeImpl extends AbstractFacadeImpl<CompetitionModel, CompetitionDTO, CompetitionForm> implements CompetitionFacade {
    @Override
    protected CompetitionDTO convertModelToDTO(final CompetitionModel competitionModel) {
        return CompetitionDTO.convert(competitionModel);
    }

    @Override
    protected CompetitionModel convertFormToModel(final CompetitionForm competitionForm) {
        return CompetitionForm.convert(competitionForm);
    }
}
