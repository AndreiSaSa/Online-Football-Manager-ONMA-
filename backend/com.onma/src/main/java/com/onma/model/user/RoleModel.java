package com.onma.model.user;

import com.onma.model.base.AbstractModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class RoleModel extends AbstractModel implements GrantedAuthority {

    @Column(nullable = false)
    @NotBlank
    private String type;

    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<UserModel> users = new ArrayList<>();

    @Override
    public String getAuthority() {
        return type;
    }

}
