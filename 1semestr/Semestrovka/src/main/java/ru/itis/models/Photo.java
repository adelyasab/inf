package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Photo {
    private Long id;
    private String originFileName;
    private String storageFileName;
    private Long size;
    private String type;
    private Long idPhotosession;
}
