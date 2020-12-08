package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String firstname;
    private String lastname;
    private String hashPassword;
    private String email;
    private Long mainPhotoId;

    public User(Long id, String firstname, String lastname, String email, Long mainPhotoId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.mainPhotoId = mainPhotoId;
    }
}

