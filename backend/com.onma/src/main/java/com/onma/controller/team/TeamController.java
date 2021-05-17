package com.onma.controller.team;

import com.onma.controller.base.AbstractController;
import com.onma.dto.team.TeamDTO;
import com.onma.form.team.TeamForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController extends AbstractController<TeamDTO, TeamForm> {
}