package com.onma.service.competition;

import com.onma.model.competition.CompetitionModel;
import com.onma.model.match.MatchDataModel;
import com.onma.model.match.MatchModel;
import com.onma.repository.competition.CompetitionRepository;
import com.onma.repository.match.MatchRepository;
import com.onma.service.base.AbstractServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl extends AbstractServiceImpl<CompetitionModel> implements CompetitionService {

    private final MatchRepository matchRepository;
    private final CompetitionRepository competitionRepository;
    private final Random random = new Random();

    @Override
    public void advanceMatchDay(final CompetitionModel competition) {
        if(competition.getMatchDay() < competition.getCompetitionRules().getNumberOfTeams() * 2 - 2) {
            final List<MatchModel> matchModels = matchRepository.getByCompetitionIdAndMatchDay(competition.getId(), competition.getMatchDay());
            competition.setMatchDay(competition.getMatchDay() + 1);
            competitionRepository.save(competition);

            matchModels.forEach(this::simulateMatch);
        }
    }

    private void simulateMatch(final MatchModel matchModel) {
        final MatchDataModel matchDataModel =
                MatchDataModel.builder().
                        homeScore((long) random.nextInt(4)).
                        awayScore((long) random.nextInt(4)).
                        build();
        matchModel.setPlayed(true);
        matchModel.setMatchData(matchDataModel);
        matchRepository.save(matchModel);
    }
}
