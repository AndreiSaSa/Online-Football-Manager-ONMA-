package com.onma.service.team;

import com.onma.model.team.TeamModel;
import com.onma.service.base.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl extends AbstractServiceImpl<TeamModel> implements TeamService {
}
