package com.onma.service.competition.generation;

import com.github.javafaker.Faker;
import com.onma.config.ConstantsConfig;
import com.onma.model.competition.CompetitionModel;
import com.onma.model.match.MatchModel;
import com.onma.model.player.PlayerAttributesModel;
import com.onma.model.player.PlayerModel;
import com.onma.model.team.TeamInformationModel;
import com.onma.model.team.TeamModel;
import com.onma.service.competition.CompetitionService;
import com.onma.service.match.MatchService;
import com.onma.service.player.PlayerService;
import com.onma.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GenerationEqual implements GenerationStrategy {

    private final CompetitionService competitionService;
    private final TeamService teamService;
    private final PlayerService playerService;
    private final MatchService matchService;

    private final Faker faker = new Faker();

    @Override
    public void generateCompetition(final CompetitionModel competitionModel) {
        long numberOfTeams = competitionModel.getCompetitionRules().getNumberOfTeams();
        if(numberOfTeams % 2 == 1) {
            competitionModel.getCompetitionRules().setNumberOfTeams(numberOfTeams + 1);
            numberOfTeams++;
        }
        competitionService.saveOrUpdate(competitionModel);

        final List<TeamModel> teams = new ArrayList<>();
        while (numberOfTeams-- > 0) {
            generateTeam(teams);
        }
        numberOfTeams = competitionModel.getCompetitionRules().getNumberOfTeams();

        drawMatches(competitionModel, teams, (int) numberOfTeams);
    }

    private void generateTeam(final List<TeamModel> teams) {
        final TeamInformationModel teamInformationModel =
                TeamInformationModel.builder().
                        name(faker.team().name()).
                        transferBudget(ConstantsConfig.EQUAL_BUDGET).
                        wageBudget(ConstantsConfig.EQUAL_WAGE).
                        build();

        final TeamModel team =
                TeamModel.builder().
                        teamInformation(teamInformationModel).
                        build();

        teamService.saveOrUpdate(team);
        teams.add(team);

        for(long playerNumber = 0; playerNumber < 20; playerNumber++) {
            generatePlayer(playerNumber, team);
        }
    }

    private void generatePlayer(final Long number, final TeamModel teamModel) {
        final PlayerAttributesModel playerAttributesModel =
                PlayerAttributesModel.builder().
                        gk(ConstantsConfig.EQUAL_OVERALL).
                        def(ConstantsConfig.EQUAL_OVERALL).
                        mid(ConstantsConfig.EQUAL_OVERALL).
                        att(ConstantsConfig.EQUAL_OVERALL).
                        speed(ConstantsConfig.EQUAL_OVERALL).
                        physical(ConstantsConfig.EQUAL_OVERALL).
                        build();

        final PlayerModel playerModel =
                PlayerModel.builder().
                        name(faker.name().fullName()).
                        number(number).
                        estimatedPrice(ConstantsConfig.EQUAL_PLAYER_BUDGET).
                        wage(ConstantsConfig.EQUAL_PLAYER_WAGE).
                        transferListed(false).
                        tacticPosition(number < 19 ? number : 0).
                        team(teamModel).
                        playerAttributes(playerAttributesModel).
                        build();
        playerService.saveOrUpdate(playerModel);
    }

    private void generateMatch(final TeamModel home, final TeamModel away, final CompetitionModel competition, final Long matchDay) {
        final MatchModel matchModel =
                MatchModel.builder().
                        homeTeam(home).
                        awayTeam(away).
                        competition(competition).
                        played(false).
                        matchDay(matchDay).
                        build();
        matchService.saveOrUpdate(matchModel);
    }

    private void drawMatches(final CompetitionModel competition, final List<TeamModel> listTeam, final Integer numTeams)
    {
        int numDays = (numTeams - 1);
        int halfSize = numTeams / 2;

        List<TeamModel> teams = new ArrayList<>(listTeam);
        teams.remove(0);

        int teamsSize = numTeams - 1;

        for (int day = 0; day < numDays; day++)
        {
            int teamIdx = day % teamsSize;
            generateMatch(teams.get(teamIdx), listTeam.get(0), competition, (long) (day + 1));
            generateMatch(listTeam.get(0), teams.get(teamIdx), competition, (long) (numDays + day + 1));
            for (int idx = 1; idx < halfSize; idx++)
            {
                int firstTeam = (day + idx) % teamsSize;
                int secondTeam = (day  + teamsSize - idx) % teamsSize;
                generateMatch(teams.get(firstTeam), teams.get(secondTeam), competition, (long) (day + 1));
                generateMatch(teams.get(secondTeam), teams.get(firstTeam), competition, (long) (numDays + day + 1));
            }
        }
    }

}
