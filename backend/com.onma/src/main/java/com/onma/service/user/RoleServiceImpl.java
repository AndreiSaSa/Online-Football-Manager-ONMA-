package com.onma.service.user;

import com.onma.model.user.RoleModel;
import com.onma.service.base.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends AbstractServiceImpl<RoleModel> implements RoleService {
}
