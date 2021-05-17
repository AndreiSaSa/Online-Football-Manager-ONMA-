package com.onma.facade.team.tactic;

import com.onma.dto.team.tactic.TacticDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.team.tactic.TacticForm;
import com.onma.model.team.tactic.TacticModel;
import com.onma.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class TacticFacadeImpl extends AbstractFacadeImpl<TacticModel, TacticDTO, TacticForm> implements TacticFacade {

    private final TeamService teamService;

    @Override
    protected TacticDTO convertModelToDTO(final TacticModel tacticModel) {
        return TacticDTO.convert(tacticModel);
    }

    @Override
    protected TacticModel convertFormToModel(final TacticForm tacticForm) {
        final TacticModel tacticModel = TacticForm.convert(tacticForm);
        tacticModel.setTeam(teamService.getById(tacticForm.getTeamId()));
        return tacticModel;
    }
}
