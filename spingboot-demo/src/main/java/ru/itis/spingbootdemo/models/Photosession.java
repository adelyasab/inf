package ru.itis.spingbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Long idMainphoto;
    private Long idUser;
}
