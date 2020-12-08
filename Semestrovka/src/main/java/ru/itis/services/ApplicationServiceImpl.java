package ru.itis.services;

import ru.itis.dto.ApplicationForm;
import ru.itis.models.Application;
import ru.itis.repositories.ApplicationsRepository;

import java.util.List;

public class ApplicationServiceImpl implements ApplicationService{
    private ApplicationsRepository applicationsRepository;

    public ApplicationServiceImpl(ApplicationsRepository applicationsRepository) {
        this.applicationsRepository = applicationsRepository;
    }

    @Override
    public List<Application> getAllByWhomCustomerId(Long id) {
        return applicationsRepository.findByWhomCustomer(id);
    }

    @Override
    public List<Application> getApplicationByCustomerId(Long id) {
        return applicationsRepository.findByCustomer(id);
    }

    @Override
    public List<Application> getAll() {
        return applicationsRepository.getAll();
    }

    @Override
    public void giveApplication(ApplicationForm applicationForm) {
        Application application = Application.builder().
                phoneNumber(applicationForm.getPhoneNumber()).
                photosessionId(applicationForm.getPhotosessionId()).
                customerId(applicationForm.getCustomerId()).
                date(applicationForm.getDate()).
                name(applicationForm.getName()).
                time(applicationForm.getTime()).
                photosessionByUserId(applicationForm.getPhotosessionByUserId()).
                build();
        applicationsRepository.save(application);
    }
}
