package ru.itis.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Application {
    private Long id;
    private String date;
    private String time;
    private Long customerId;
    private Long photosessionId;
    private String phoneNumber;
    private String name;
    private Long photosessionByUserId;
}
