package ru.itis.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T>{
    void update(T entity);
    Long save(T entity);
    void delete(Long id);
    Optional<T> findById(Long id);
    List<T> findAll();

}
