package com.onma.controller.competition;

import com.onma.controller.base.AbstractController;
import com.onma.dto.competition.CompetitionDTO;
import com.onma.form.competition.CompetitionForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/competition")
@RequiredArgsConstructor
public class CompetitionController extends AbstractController<CompetitionDTO, CompetitionForm> {
}
