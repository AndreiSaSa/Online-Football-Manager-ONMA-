package com.onma.facade.user;

import com.onma.config.UserAuthenticationToken;
import com.onma.dto.user.UserDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.user.UserForm;
import com.onma.model.user.UserModel;
import com.onma.service.user.RoleService;
import com.onma.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class UserFacadeImpl extends AbstractFacadeImpl<UserModel, UserDTO, UserForm> implements UserFacade {

    private final UserService userService;
    private final RoleService roleService;

    @Override
    protected UserDTO convertModelToDTO(final UserModel userModel) {
        return UserDTO.convert(userModel);
    }

    @Override
    protected UserModel convertFormToModel(final UserForm userForm) {
        final UserModel userModel = UserForm.convert(userForm);
        userModel.setRole(roleService.getById(userModel.getRole().getId()));
        return userModel;
    }

    @Override
    public UserAuthenticationToken login(final UserForm userForm) {
        final UserModel user = UserForm.convert(userForm);
        UserModel loggedUser = userService.login(user);

        final String credentials = loggedUser.getUsername() + ":" + loggedUser.getPassword();
        final String authorization = "Basic " + Base64.encodeBase64String(credentials.getBytes());

        final UserAuthenticationToken authenticationToken = new UserAuthenticationToken();

        authenticationToken.setAuthenticationToken(authorization);
        authenticationToken.setUserId(loggedUser.getId());
        authenticationToken.setUserRole(loggedUser.getRole().getType());

        return authenticationToken;
    }

    @Override
    public void register(final UserForm userForm) {
        final UserModel userModel = UserForm.convert(userForm);
        userModel.setRole(roleService.getById(3L));
        userService.saveOrUpdate(userModel);
    }
}
