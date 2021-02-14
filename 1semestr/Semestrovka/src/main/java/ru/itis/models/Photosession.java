package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photosession {
    private Long id;
    private String name;
    private String type;
    private int price;
    private Long idMainPhoto;
    private Long idUser;
}
