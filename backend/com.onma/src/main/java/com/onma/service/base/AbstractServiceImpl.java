package com.onma.service.base;

import com.onma.model.base.AbstractModel;
import com.onma.repository.base.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractServiceImpl<MODEL extends AbstractModel> implements AbstractService<MODEL> {

    @Autowired
    private AbstractRepository<MODEL> repository;

    @Override
    public List<MODEL> getAll() {
        return repository.findAll();
    }

    @Override
    public MODEL getById(final Long id) {
        return repository.getById(id);
    }

    @Override
    public void saveOrUpdate(final MODEL model) {
        repository.save(model);
    }

    @Override
    public void deleteById(final Long id) {
        repository.deleteById(id);
    }
}
