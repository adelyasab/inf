package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApplicationForm {
    @NotEmpty
    private String date;
    @NotEmpty
    private String time;
    private Long customerId;
    private Long photosessionId;
    @NotEmpty
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")
    private String phoneNumber;
    @NotEmpty
    @Length(min = 3, max = 30)
    private String name;
    private Long photosessionByUserId;
}
