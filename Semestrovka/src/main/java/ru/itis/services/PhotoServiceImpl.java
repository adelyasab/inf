package ru.itis.services;
import ru.itis.dto.PhotoForm;
import ru.itis.models.Photo;
import ru.itis.repositories.PhotoRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class PhotoServiceImpl implements PhotoService {
    private PhotoRepository photoRepository;

    public PhotoServiceImpl(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Long savePhotoToStorage(InputStream file, PhotoForm photoForm) {
        Photo photo = Photo.builder().originFileName(photoForm.getOriginFileName()).
                size(photoForm.getSize()).
                storageFileName(UUID.randomUUID().toString()).
                type(photoForm.getType()).
                idPhotosession(photoForm.getIdPhotosession()).
                build();
        try {
            Files.copy(file, Paths.get("C://files/" + photo.getStorageFileName() + "." +
                    photo.getType().split("/")[1]));
            return photoRepository.save(photo);
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeFileFromStorage(Long fileId, OutputStream outputStream) {
        Photo photo = photoRepository.findById(fileId).get();
        File file = new File("C://files" + "/" + photo.getStorageFileName() + "."
                + photo.getType().split("/")[1]);
        try {
            Files.copy(file.toPath(), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }



    @Override
    public Photo getFileInfo(Long fileId) {
        return photoRepository.findById(fileId).get();
    }

    @Override
    public void changePhotosessionById(Long fileId, Long photosetId) {
        photoRepository.changingPhotosessionById(fileId, photosetId);
    }
}
