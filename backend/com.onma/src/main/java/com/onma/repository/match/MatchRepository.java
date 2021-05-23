package com.onma.repository.match;

import com.onma.model.match.MatchModel;
import com.onma.repository.base.AbstractRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends AbstractRepository<MatchModel> {
    List<MatchModel> getByCompetitionIdAndMatchDay(final Long competitionId, final Long matchDay);
}
