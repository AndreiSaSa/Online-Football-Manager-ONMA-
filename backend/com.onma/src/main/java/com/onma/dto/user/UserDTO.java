package com.onma.dto.user;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class UserDTO extends AbstractDTO {

    private String username;
    private String email;
    private RoleDTO role;
    private ProfileDTO profile;

    public static UserDTO convert(final UserModel userModel) {
        return UserDTO.builder().
                id(userModel.getId()).
                username(userModel.getUsername()).
                email(userModel.getEmail()).
                profile(ProfileDTO.convert(userModel.getProfile())).
                role(RoleDTO.convert(userModel.getRole())).
                build();
    }
}
