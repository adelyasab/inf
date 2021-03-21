package ru.itis.spingbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="photo2")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storageFilename;
    private String originalFilename;
    private String type;
    private Integer size;

    @OneToOne(mappedBy = "mainPhoto")
    private Photosession photosession;

}
