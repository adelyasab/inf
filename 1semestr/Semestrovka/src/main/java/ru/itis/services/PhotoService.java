package ru.itis.services;

import ru.itis.dto.PhotoForm;
import ru.itis.models.Photo;

import java.io.InputStream;
import java.io.OutputStream;

public interface PhotoService {
    Long savePhotoToStorage(InputStream file, PhotoForm photoForm);
    void writeFileFromStorage(Long fileId, OutputStream outputStream);
    Photo getFileInfo(Long fileId);
    void changePhotosessionById(Long photoId, Long phtosetId);
}
