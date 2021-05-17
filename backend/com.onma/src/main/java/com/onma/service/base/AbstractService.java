package com.onma.service.base;

import com.onma.model.base.AbstractModel;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface AbstractService<MODEL extends AbstractModel> {
    List<MODEL> getAll();
    MODEL getById(final Long id);
    void saveOrUpdate(final MODEL model);
    void deleteById(final Long id);
}
