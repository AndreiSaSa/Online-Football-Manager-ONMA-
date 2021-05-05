package com.onma.model.user;

import com.onma.model.base.AbstractModel;
import com.onma.model.team.TeamModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class UserModel extends AbstractModel implements UserDetails {

    @Column(nullable = false, unique = true)
    @Size(min = 4)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @NotNull
    private ProfileModel profile;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TeamModel> activeTeams;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private RoleModel role;

    private boolean enabled = true;

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<RoleModel> roles = new ArrayList<>();
        roles.add(role);
        return roles;
    }

}

