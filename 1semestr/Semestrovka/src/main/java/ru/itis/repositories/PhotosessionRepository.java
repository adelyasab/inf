package ru.itis.repositories;

import ru.itis.models.Photosession;
import ru.itis.models.User;

import java.util.List;
import java.util.Optional;

public interface PhotosessionRepository extends CrudRepository<Photosession>{
    List<Photosession> getAllByUserId(Long id);
    List<Photosession> getAllCheaper(int price);
    List<Photosession> getAllCheaperAndType(int price, String type);
    List<Photosession> getAllType(String type);

    Optional<Photosession> getUserIdByPhotosession(Long photosessionId);
}
