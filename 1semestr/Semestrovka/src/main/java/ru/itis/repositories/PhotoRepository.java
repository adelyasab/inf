package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import ru.itis.models.Photo;

import java.util.Optional;


public interface PhotoRepository extends CrudRepository<Photo>{
    void changingPhotosessionById(Long id, Long photoset_id);
}
