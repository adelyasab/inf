package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PhotosessionDto {
    private Long id;
    private String name;
    private String type;
    private Long idMainPhoto;
    private Long idUser;
}
