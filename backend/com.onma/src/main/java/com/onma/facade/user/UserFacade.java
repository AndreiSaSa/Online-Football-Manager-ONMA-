package com.onma.facade.user;

import com.onma.config.UserAuthenticationToken;
import com.onma.dto.user.UserDTO;
import com.onma.facade.base.AbstractFacade;
import com.onma.form.user.UserForm;

public interface UserFacade extends AbstractFacade<UserDTO, UserForm> {
    UserAuthenticationToken login(final UserForm user);
    void register(final UserForm userForm);
}
