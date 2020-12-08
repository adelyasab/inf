package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HelperInAllPhotosession{
    Long id;
    String photosession_name;
    String photo_type;
    String photo_storage_name;
}
