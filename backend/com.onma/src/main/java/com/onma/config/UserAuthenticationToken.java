package com.onma.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAuthenticationToken {

    private String authenticationToken;
    private Long userId;
    private String userRole;

}