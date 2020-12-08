package ru.itis.repositories;

import ru.itis.models.Application;

import java.util.List;

public interface ApplicationsRepository extends CrudRepository<Application> {
    List<Application> findByCustomer(Long id);
    List<Application> getAll();

    List<Application> findByWhomCustomer(Long id);
}
