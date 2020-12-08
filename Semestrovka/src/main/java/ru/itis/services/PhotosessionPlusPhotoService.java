package ru.itis.services;

import ru.itis.models.PhotosessionPlusPhoto;

import java.util.List;

public interface PhotosessionPlusPhotoService{
    List<PhotosessionPlusPhoto> findAll();
    void save(PhotosessionPlusPhoto ppp);
}
