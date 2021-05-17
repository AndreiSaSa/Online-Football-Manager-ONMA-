package com.onma.form.user;

import com.onma.form.base.AbstractForm;
import com.onma.model.user.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class RoleForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String type;

    public static RoleModel convert(final RoleForm roleForm) {
        return RoleModel.builder().
                id(roleForm.getId()).
                type(roleForm.type).
                build();
    }

}
