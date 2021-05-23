package com.onma.controller.competition;

import com.onma.controller.base.AbstractController;
import com.onma.dto.competition.CompetitionDTO;
import com.onma.facade.competition.CompetitionFacade;
import com.onma.form.competition.CompetitionForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/competition")
@RequiredArgsConstructor
public class CompetitionController extends AbstractController<CompetitionDTO, CompetitionForm> {

    private final CompetitionFacade competitionFacade;

    @PostMapping("/generate-equal")
    public void generateEqual(@RequestBody @Valid final CompetitionForm form) {
        competitionFacade.generateEqual(form);
    }

    @PostMapping("/generate-random")
    public void generateRandom(@RequestBody @Valid final CompetitionForm form) {
        competitionFacade.generateRandom(form);
    }

    @PostMapping("/{id}/advance-match-day")
    public void advanceMatchDay(@RequestParam @Valid final Long competitionId) {
        competitionFacade.advanceMatchDay(competitionId);
    }

}
