package com.onma.repository.user;

import com.onma.model.user.UserModel;
import com.onma.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<UserModel> {
    UserModel getByUsername(final String username);
}
