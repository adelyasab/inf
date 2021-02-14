package ru.itis.services;

import ru.itis.dto.PhotosessionForm;
import ru.itis.models.Photo;
import ru.itis.models.Photosession;
import ru.itis.models.User;
import ru.itis.repositories.PhotoRepository;
import ru.itis.repositories.PhotosessionRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PhotosessionServiceImpl implements PhotosessionService {

    private PhotosessionRepository photosessionRepository;

    public PhotosessionServiceImpl(PhotosessionRepository photosessionRepository) {
        this.photosessionRepository = photosessionRepository;
    }

    @Override
    public Optional<Photosession> getUserIdByPhotosession(Long photosessionId) {
        return photosessionRepository.getUserIdByPhotosession(photosessionId);
    }

    @Override
    public Long savePhotosessionToStorage(PhotosessionForm photosessionForm) {
        Photosession photosession = Photosession.builder().
                name(photosessionForm.getName()).
                type(photosessionForm.getType()).
                price(photosessionForm.getPrice()).
                idMainPhoto(photosessionForm.getIdMainPhoto()).
                idUser(photosessionForm.getIdUser()).
                build();
            return photosessionRepository.save(photosession);
    }

    @Override
    public List<Photosession> findAllCheaper(int price) {
        return photosessionRepository.getAllCheaper(price);
    }

    @Override
    public List<Photosession> findAllCheaperAndType(int price, String type) {
        return photosessionRepository.getAllCheaperAndType(price, type);
    }

    @Override
    public List<Photosession> getPhotosessionsWithUserId(Long id) {
        return photosessionRepository.getAllByUserId(id);
    }
}