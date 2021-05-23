package com.onma.controller.team;

import com.onma.controller.base.AbstractController;
import com.onma.dto.team.TeamDTO;
import com.onma.facade.team.TeamFacade;
import com.onma.form.team.TeamForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController extends AbstractController<TeamDTO, TeamForm> {

    private final TeamFacade teamFacade;

    @PostMapping("/{id}/select")
    public void selectTeam(@RequestParam @Valid final Long teamId) {
        teamFacade.selectTeam(teamId);
    }
}
