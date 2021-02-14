package ru.itis.spingbootdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.spingbootdemo.models.Photosession;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PhotosessionDto {
    private Long id;
    private String photosessionName;

    public static PhotosessionDto from(Photosession photosession) {
        return PhotosessionDto.builder()
                .id(photosession.getId())
                .photosessionName(photosession.getName())
                .build();
    }

    public static List<PhotosessionDto> from(List<Photosession> photosessions) {
        return photosessions.stream().map(PhotosessionDto::from).collect(Collectors.toList());
    }
}
