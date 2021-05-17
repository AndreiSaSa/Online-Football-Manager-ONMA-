package com.onma.dto.user;

import com.onma.dto.base.AbstractDTO;
import com.onma.model.user.ProfileModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class ProfileDTO extends AbstractDTO {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDateTime birthDate;
    private Long points;

    public static ProfileDTO convert(final ProfileModel profileModel) {
        return ProfileDTO.builder().
                id(profileModel.getId()).
                firstName(profileModel.getFirstName()).
                lastName(profileModel.getLastName()).
                gender(profileModel.getGender()).
                birthDate(profileModel.getBirthDate()).
                points(profileModel.getPoints()).
                build();
    }

}
