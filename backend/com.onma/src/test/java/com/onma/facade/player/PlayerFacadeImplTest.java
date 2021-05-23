package com.onma.facade.player;

import com.onma.model.player.PlayerModel;
import com.onma.model.team.TeamInformationModel;
import com.onma.model.team.TeamModel;
import com.onma.model.user.UserModel;
import com.onma.service.player.PlayerService;
import com.onma.service.team.TeamService;
import com.onma.service.user.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerFacadeImplTest {

    @Mock
    private TeamService teamService;
    @Mock
    private PlayerService playerService;
    @Mock
    private UserService userService;

    @InjectMocks
    private PlayerFacadeImpl playerFacade;

    @Before
    public void setUp() {
    }

    @Test(expected = RuntimeException.class)
    public void buy_playerNotListed() {
        final PlayerModel playerModel = new PlayerModel();
        playerModel.setTransferListed(false);
        when(playerService.getById(anyLong())).thenReturn(playerModel);
        playerFacade.buy(1L, 1L);
    }

    @Test(expected = RuntimeException.class)
    public void buy_userDoesNotCorrespond() {
        final PlayerModel playerModel = new PlayerModel();
        playerModel.setTransferListed(true);
        when(playerService.getById(anyLong())).thenReturn(playerModel);

        final SecurityContext securityContext = mock(SecurityContext.class);
        try (MockedStatic<SecurityContextHolder> utilities = Mockito.mockStatic(SecurityContextHolder.class)) {
            utilities.when(SecurityContextHolder::getContext).thenReturn(securityContext);
        }

        final Authentication authentication = mock(Authentication.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        final UserModel principal = new UserModel();
        principal.setId(1L);
        when(authentication.getPrincipal()).thenReturn(principal);

        final TeamModel teamModel = new TeamModel();
        final UserModel userModel = new UserModel();
        userModel.setId(1L);
        teamModel.setUser(userModel);
        when(teamService.getById(anyLong())).thenReturn(teamModel);

        playerFacade.buy(1L, 1L);
    }

    @Test(expected = RuntimeException.class)
    public void buy_playerFromOwnTeam() {
        final PlayerModel playerModel = new PlayerModel();
        playerModel.setTransferListed(true);
        when(playerService.getById(anyLong())).thenReturn(playerModel);

        final SecurityContext securityContext = mock(SecurityContext.class);
        try (MockedStatic<SecurityContextHolder> utilities = Mockito.mockStatic(SecurityContextHolder.class)) {
            utilities.when(SecurityContextHolder::getContext).thenReturn(securityContext);
        }

        final Authentication authentication = mock(Authentication.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        final UserModel principal = new UserModel();
        principal.setId(1L);
        when(authentication.getPrincipal()).thenReturn(principal);

        final TeamModel teamModel = new TeamModel();
        final UserModel userModel = new UserModel();
        userModel.setId(2L);
        teamModel.setUser(userModel);
        when(teamService.getById(anyLong())).thenReturn(teamModel);

        playerFacade.buy(1L, 1L);
    }

    @Test(expected = RuntimeException.class)
    public void buy_notEnoughWage() {
        final PlayerModel playerModel = new PlayerModel();
        playerModel.setTransferListed(true);
        when(playerService.getById(anyLong())).thenReturn(playerModel);

        final SecurityContext securityContext = mock(SecurityContext.class);
        try (MockedStatic<SecurityContextHolder> utilities = Mockito.mockStatic(SecurityContextHolder.class)) {
            utilities.when(SecurityContextHolder::getContext).thenReturn(securityContext);
        }

        final Authentication authentication = mock(Authentication.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        final UserModel principal = new UserModel();
        principal.setId(1L);
        when(authentication.getPrincipal()).thenReturn(principal);

        final TeamModel teamModel = new TeamModel();
        final UserModel userModel = new UserModel();
        userModel.setId(2L);
        teamModel.setUser(userModel);
        final TeamInformationModel teamInformationModel = new TeamInformationModel();
        teamInformationModel.setTransferBudget(10L);
        teamInformationModel.setWageBudget(10000000000L);
        teamModel.setTeamInformation(teamInformationModel);

        when(teamService.getById(anyLong())).thenReturn(teamModel);

        playerModel.setEstimatedPrice(10000L);
        playerModel.setWage(10L);

        playerFacade.buy(1L, 1L);
    }

    @Test(expected = RuntimeException.class)
    public void buy_notEnoughBudget() {
        final PlayerModel playerModel = new PlayerModel();
        playerModel.setTransferListed(true);
        when(playerService.getById(anyLong())).thenReturn(playerModel);

        final SecurityContext securityContext = mock(SecurityContext.class);
        try (MockedStatic<SecurityContextHolder> utilities = Mockito.mockStatic(SecurityContextHolder.class)) {
            utilities.when(SecurityContextHolder::getContext).thenReturn(securityContext);
        }

        final Authentication authentication = mock(Authentication.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);

        final UserModel principal = new UserModel();
        principal.setId(1L);
        when(authentication.getPrincipal()).thenReturn(principal);

        final TeamModel teamModel = new TeamModel();
        final UserModel userModel = new UserModel();
        userModel.setId(2L);
        teamModel.setUser(userModel);
        final TeamInformationModel teamInformationModel = new TeamInformationModel();
        teamInformationModel.setTransferBudget(1000000L);
        teamInformationModel.setWageBudget(10L);
        teamModel.setTeamInformation(teamInformationModel);

        when(teamService.getById(anyLong())).thenReturn(teamModel);

        playerModel.setEstimatedPrice(10L);
        playerModel.setWage(100000L);

        playerFacade.buy(1L, 1L);
    }

    @After
    public void tearDown() {
    }
}