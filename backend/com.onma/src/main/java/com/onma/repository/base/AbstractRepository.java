package com.onma.repository.base;

import com.onma.model.base.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractRepository<MODEL extends AbstractModel> extends JpaRepository<MODEL, Long> {
    MODEL getById(final Long id);
}
