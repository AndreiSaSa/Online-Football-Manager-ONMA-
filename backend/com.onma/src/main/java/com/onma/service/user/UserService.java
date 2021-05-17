package com.onma.service.user;

import com.onma.model.user.UserModel;
import com.onma.service.base.AbstractService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends AbstractService<UserModel>, UserDetailsService {
    UserModel login(final UserModel user);
}
