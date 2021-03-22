package ru.itis.spingbootdemo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //имя в хранилище
    private String storageFileName;
    //оригинальное название файла
    private String originalFileName;
    //тип файла (image/jpg, audio/mp3) - MIME
    private String type;
    //размер
    private Long size;
    //URL для получения файла
    private String url;
}
