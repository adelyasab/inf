package ru.itis.spingbootdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.spingbootdemo.dto.PhotosessionDto;
import ru.itis.spingbootdemo.models.Photosession;
import ru.itis.spingbootdemo.repositories.PhotosessionsRepository;

import java.util.List;

@Component
public class PhotosessionsServiceImpl implements PhotosessionsService{

    @Autowired
    private PhotosessionsRepository photosessionsRepository;

    @Override
    public List<PhotosessionDto> getAllPhotosessions() {
        List<Photosession> photosessions = photosessionsRepository.findAll();
        return PhotosessionDto.from(photosessions);
    }

    @Override
    public List<PhotosessionDto> getPhotosessions(int price) {
        return PhotosessionDto.from(photosessionsRepository.findAllByPriceIsBefore(price));
    }

    @Override
    public List<PhotosessionDto> getPhotosessions(String type, int price) {
        return PhotosessionDto.from(photosessionsRepository.findAllByPriceIsBeforeAndType(price,type));
    }
}





















































































