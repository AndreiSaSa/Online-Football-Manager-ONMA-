package com.onma.form.user;

import com.onma.form.base.AbstractForm;
import com.onma.model.user.ProfileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class ProfileForm extends AbstractForm {

    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^M|F|N$")
    private String gender;

    @NotNull
    private LocalDateTime birthDate;

    @NotNull
    private Long points;

    public static ProfileModel convert(final ProfileForm profileForm) {
        return ProfileModel.builder().
                id(profileForm.getId()).
                firstName(profileForm.firstName).
                lastName(profileForm.lastName).
                gender(profileForm.gender).
                birthDate(profileForm.birthDate).
                points(profileForm.points).
                build();
    }

}
