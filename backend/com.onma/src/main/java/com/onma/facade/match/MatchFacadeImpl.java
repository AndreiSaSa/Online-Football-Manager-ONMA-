package com.onma.facade.match;

import com.onma.dto.match.MatchDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.match.MatchForm;
import com.onma.model.match.MatchModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class MatchFacadeImpl extends AbstractFacadeImpl<MatchModel, MatchDTO, MatchForm> implements MatchFacade {
    @Override
    protected MatchDTO convertModelToDTO(final MatchModel matchModel) {
        return MatchDTO.convert(matchModel);
    }

    @Override
    protected MatchModel convertFormToModel(final MatchForm matchForm) {
        return MatchForm.convert(matchForm);
    }
}
