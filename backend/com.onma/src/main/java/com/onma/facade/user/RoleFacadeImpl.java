package com.onma.facade.user;

import com.onma.dto.user.RoleDTO;
import com.onma.facade.base.AbstractFacadeImpl;
import com.onma.form.user.RoleForm;
import com.onma.model.user.RoleModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class RoleFacadeImpl extends AbstractFacadeImpl<RoleModel, RoleDTO, RoleForm> implements RoleFacade {

    @Override
    protected RoleDTO convertModelToDTO(final RoleModel roleModel) {
        return RoleDTO.convert(roleModel);
    }

    @Override
    protected RoleModel convertFormToModel(final RoleForm roleForm) {
        return RoleForm.convert(roleForm);
    }
}
