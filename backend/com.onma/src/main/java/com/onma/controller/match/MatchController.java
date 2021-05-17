package com.onma.controller.match;

import com.onma.controller.base.AbstractController;
import com.onma.dto.match.MatchDTO;
import com.onma.form.match.MatchForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchController extends AbstractController<MatchDTO, MatchForm> {
}
