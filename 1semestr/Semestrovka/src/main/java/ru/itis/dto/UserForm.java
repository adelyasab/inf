package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserForm {
    @NotEmpty
    @Length(min = 8, max = 30)
    public String password;
    @NotEmpty
    @Email
    public String email;
    @NotEmpty
    @Length(min = 3, max = 30)
    public String firstName;
    @NotEmpty
    @Length(min = 3, max = 30)
    public String lastName;
    private Long mainPhotoId;
}
