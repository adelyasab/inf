package ru.itis.services;

import ru.itis.dto.ApplicationForm;
import ru.itis.models.Application;

import java.util.Collection;
import java.util.List;


public interface ApplicationService {
    void giveApplication(ApplicationForm applicationForm);
    List<Application> getApplicationByCustomerId(Long id);
    List<Application> getAll();

    List<Application> getAllByWhomCustomerId(Long id);
}
