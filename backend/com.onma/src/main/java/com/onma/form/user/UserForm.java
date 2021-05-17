package com.onma.form.user;

import com.onma.form.base.AbstractForm;
import com.onma.model.user.RoleModel;
import com.onma.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class UserForm extends AbstractForm {

    @NotNull
    @Size(min = 4)
    private String username;

    @NotNull
    private String password;

    @NotNull
    @Email
    private String email;

    @Valid
    private ProfileForm profile;

    @NotNull
    private Long roleId;

    public static UserModel convert(final UserForm userForm) {
        return UserModel.builder().
                id(userForm.getId()).
                username(userForm.username).
                password(userForm.password).
                email(userForm.email).
                profile(ProfileForm.convert(userForm.profile)).
                role(RoleModel.builder().id(userForm.roleId).build()).
                enabled(true).
                build();
    }

}
