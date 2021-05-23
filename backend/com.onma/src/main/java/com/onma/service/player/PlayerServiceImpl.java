package com.onma.service.player;

import com.onma.model.player.PlayerModel;
import com.onma.model.team.TeamModel;
import com.onma.repository.player.PlayerRepository;
import com.onma.service.base.AbstractServiceImpl;
import com.onma.service.player.observer.LogObserver;
import com.onma.service.player.observer.MailObserver;
import com.onma.service.player.observer.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl extends AbstractServiceImpl<PlayerModel> implements PlayerService {

    private final PlayerRepository playerRepository;
    private final Subject subject;

    public PlayerServiceImpl(final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

        this.subject = new Subject();
        new LogObserver(subject);
        new MailObserver(subject);
    }

    @Override
    public List<PlayerModel> getAllTransferListed() {
        return playerRepository.getByTransferListedTrue();
    }

    @Override
    public void saveOrUpdateTransfer(final PlayerModel playerModel, final TeamModel from, final TeamModel to) {
        subject.setMessage("Player " + playerModel.getName() + " has moved from " + from.getTeamInformation().getName() + " to " + to.getTeamInformation().getName());
        playerRepository.save(playerModel);
    }
}
