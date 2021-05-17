package com.onma.dto.user;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.user.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class RoleDTO extends AbstractDTO {

    private String type;

    public static RoleDTO convert(final RoleModel roleModel) {
        return RoleDTO.builder().
                id(roleModel.getId()).
                type(roleModel.getType()).
                build();
    }
}