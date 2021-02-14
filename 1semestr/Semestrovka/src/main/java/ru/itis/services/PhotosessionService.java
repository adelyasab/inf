package ru.itis.services;

import ru.itis.dto.PhotosessionForm;
import ru.itis.models.Photosession;
import ru.itis.models.User;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface PhotosessionService {
    List<Photosession> getPhotosessionsWithUserId(Long id);
    Long savePhotosessionToStorage(PhotosessionForm photosessionForm);
    List<Photosession> findAllCheaper(int price);
    List<Photosession> findAllCheaperAndType(int price, String type);
    Optional<Photosession> getUserIdByPhotosession(Long photosessionId);
}