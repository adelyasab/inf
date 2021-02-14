package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PhotosessionForm {
    @NotEmpty
    @Length(min = 3, max = 30)
    private String name;
    @NotEmpty
    private String type;
    private Long idMainPhoto;
    private Long idUser;
    @NotEmpty
    @NumberFormat
    private int price;
}
