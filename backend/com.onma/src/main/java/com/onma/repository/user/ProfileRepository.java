package com.onma.repository.user;

import com.onma.model.user.ProfileModel;
import com.onma.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends AbstractRepository<ProfileModel> {
}
