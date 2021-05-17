package com.onma.facade.base;

import java.util.List;

public interface AbstractFacade<DTO, FORM> {
    List<DTO> getAll();
    DTO getById(final Long id);
    void saveOrUpdate(final FORM model);
    void deleteById(final Long id);
}
