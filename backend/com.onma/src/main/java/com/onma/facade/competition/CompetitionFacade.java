package com.onma.facade.competition;

import com.onma.dto.competition.CompetitionDTO;
import com.onma.facade.base.AbstractFacade;
import com.onma.form.competition.CompetitionForm;

public interface CompetitionFacade extends AbstractFacade<CompetitionDTO, CompetitionForm> {
    void generateEqual(final CompetitionForm competitionForm);
    void generateRandom(final CompetitionForm competitionForm);
    void advanceMatchDay(final Long competitionId);
}
