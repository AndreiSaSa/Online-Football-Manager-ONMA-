package com.onma.repository.player;

import com.onma.model.player.PlayerModel;
import com.onma.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends AbstractRepository<PlayerModel> {
    List<PlayerModel> getByTransferListedTrue();
}
