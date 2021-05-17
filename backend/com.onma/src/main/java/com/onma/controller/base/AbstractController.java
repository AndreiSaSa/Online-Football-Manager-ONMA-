package com.onma.controller.base;

import com.onma.facade.base.AbstractFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public abstract class AbstractController<DTO, FORM> {

    @Autowired
    private AbstractFacade<DTO, FORM> abstractFacade;

    @PostMapping
    void saveOrUpdate(@RequestBody @Valid final FORM form) {
        abstractFacade.saveOrUpdate(form);
    }

    @GetMapping("/{id}")
    public DTO getById(@PathVariable final Long id) {
        return abstractFacade.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        abstractFacade.deleteById(id);
    }

    @GetMapping
    public List<DTO> getAll() {
        return abstractFacade.getAll();
    }
}
