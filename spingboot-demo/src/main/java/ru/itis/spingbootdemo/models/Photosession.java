package ru.itis.spingbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="photosession")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Photosession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="main_photo_id")
    private Photo mainPhoto;

    @OneToMany(mappedBy = "photosession")
    private List<Application> application;
}
