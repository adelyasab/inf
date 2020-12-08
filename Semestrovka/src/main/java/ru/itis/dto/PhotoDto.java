package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PhotoDto {
    private Long id;
    private String originFileName;
    private String storageFileName;
    private Long size;
    private String type;
    private Long idPhotosession;
}
