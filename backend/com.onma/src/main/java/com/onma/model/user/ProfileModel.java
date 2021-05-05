package com.onma.model.user;

import com.onma.model.base.AbstractModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity
@Table(name = "profile")
@Getter
@Setter
@SuperBuilder
@RequiredArgsConstructor
public class ProfileModel extends AbstractModel {

    @Column(nullable = false)
    @NotBlank
    private String firstName;

    @Column(nullable = false)
    @NotBlank
    private String lastName;

    @Column(nullable = false)
    @NotBlank
    @Pattern(regexp = "^M|F|N$")
    private String gender;

    @Column(nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false)
    private Long points;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "profile")
    @NotNull
    private UserModel user;
}
