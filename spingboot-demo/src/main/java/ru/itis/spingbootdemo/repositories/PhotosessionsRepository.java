package ru.itis.spingbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.spingbootdemo.models.Photosession;

import java.util.List;

@Repository
public interface PhotosessionsRepository extends JpaRepository<Photosession, Long> {

    List<Photosession> findAllByPriceIsBefore(int price);
    List<Photosession> findAllByPriceIsBeforeAndType(int price, String type);
}
