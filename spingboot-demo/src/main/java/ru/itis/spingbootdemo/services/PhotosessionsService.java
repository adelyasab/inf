package ru.itis.spingbootdemo.services;

import ru.itis.spingbootdemo.dto.PhotosessionDto;

import java.util.List;

public interface PhotosessionsService {
    public List<PhotosessionDto> getAllPhotosessions();
    public List<PhotosessionDto> getPhotosessions(String type, int price);
    public List<PhotosessionDto> getPhotosessions(int price);
}
