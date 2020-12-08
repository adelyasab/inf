package ru.itis.services;

import ru.itis.models.PhotosessionPlusPhoto;
import ru.itis.repositories.PhotosessionPlusPhotoRepository;

import java.util.List;

public class PhotosessionPlusPhotoServiceImpl implements PhotosessionPlusPhotoService{

    private PhotosessionPlusPhotoRepository photosessionPlusPhotoRepository;

    public PhotosessionPlusPhotoServiceImpl(PhotosessionPlusPhotoRepository photosessionPlusPhotoRepository) {
        this.photosessionPlusPhotoRepository = photosessionPlusPhotoRepository;
    }

    @Override
    public void save(PhotosessionPlusPhoto ppp) {
        photosessionPlusPhotoRepository.save(ppp);
    }

    @Override
    public List<PhotosessionPlusPhoto> findAll() {
        return photosessionPlusPhotoRepository.findAll();
    }
}
