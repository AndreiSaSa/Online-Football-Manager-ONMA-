package com.onma.facade.base;

import com.onma.model.base.AbstractModel;
import com.onma.service.base.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
public abstract class AbstractFacadeImpl<MODEL extends AbstractModel, DTO, FORM> implements AbstractFacade<DTO, FORM> {

    @Autowired
    private AbstractService<MODEL> abstractService;

    @Override
    public List<DTO> getAll() {
        return abstractService.getAll().stream().map(this::convertModelToDTO).collect(Collectors.toList());
    }

    @Override
    public DTO getById(final Long id) {
        return convertModelToDTO(abstractService.getById(id));
    }

    @Override
    public void saveOrUpdate(final FORM form) {
        abstractService.saveOrUpdate(convertFormToModel(form));
    }

    @Override
    public void deleteById(final Long id) {
        abstractService.deleteById(id);
    }

    protected abstract DTO convertModelToDTO(final MODEL model);
    protected abstract MODEL convertFormToModel(final FORM form);
}
