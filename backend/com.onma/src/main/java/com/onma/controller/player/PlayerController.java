package com.onma.controller.player;

import com.onma.controller.base.AbstractController;
import com.onma.dto.player.PlayerDTO;
import com.onma.form.player.PlayerForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController extends AbstractController<PlayerDTO, PlayerForm> {
}
