package com.onma.controller.user;

import com.onma.config.UserAuthenticationToken;
import com.onma.controller.base.AbstractController;
import com.onma.dto.user.UserDTO;
import com.onma.facade.user.UserFacade;
import com.onma.form.user.UserForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController extends AbstractController<UserDTO, UserForm> {

    private final UserFacade userFacade;

    @PostMapping("/login")
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public UserAuthenticationToken login(@RequestBody final UserForm user) {
        return userFacade.login(user);
    }

    @PostMapping("register")
    public void createUser(@RequestBody @Valid final UserForm userForm) {
        userFacade.register(userForm);
    }

}
