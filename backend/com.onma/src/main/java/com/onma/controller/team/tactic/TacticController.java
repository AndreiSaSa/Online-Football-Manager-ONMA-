package com.onma.controller.team.tactic;

import com.onma.controller.base.AbstractController;
import com.onma.dto.team.tactic.TacticDTO;
import com.onma.form.team.tactic.TacticForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tactic")
@RequiredArgsConstructor
public class TacticController extends AbstractController<TacticDTO, TacticForm> {
}
