package com.onma.controller.user;

import com.onma.controller.base.AbstractController;
import com.onma.dto.user.RoleDTO;
import com.onma.form.user.RoleForm;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController extends AbstractController<RoleDTO, RoleForm> {
}