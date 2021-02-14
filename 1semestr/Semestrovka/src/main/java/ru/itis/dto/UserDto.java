package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import ru.itis.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Long mainPhotoId;
    public static UserDto from(User user) {
        return UserDto.builder().
                id(user.getId()).
                email(user.getEmail()).
                firstName(user.getFirstname()).
                lastName(user.getLastname()).
                mainPhotoId(user.getMainPhotoId()).
                build();
    }
}
