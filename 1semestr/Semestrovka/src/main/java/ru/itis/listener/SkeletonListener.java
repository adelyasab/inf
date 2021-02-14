package ru.itis.listener;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.*;
import ru.itis.services.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@WebListener
public class SkeletonListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setPassword("adelka0508");
        dataSource.setUsername("postgres");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        PhotoRepository photoRepository = new PhotoRepositoryImpl(dataSource);
        ApplicationsRepository applicationsRepository = new ApplicationsRepositoryImpl(dataSource);
        PhotosessionRepository photosessionRepository = new PhotosessionRepositoryImpl(dataSource);
        PhotosessionPlusPhotoRepository pppRepository = new PhotosessionPlusPhotoRepositoryImpl(dataSource);
        SignUpService signUpService = new SignUpServiceImpl(usersRepository, passwordEncoder);
        SignInService signInService = new SignInServiceImpl(usersRepository, passwordEncoder);
        PhotoService photoService = new PhotoServiceImpl(photoRepository);
        PhotosessionService photosessionService = new PhotosessionServiceImpl(photosessionRepository);
        ApplicationService applicationService = new ApplicationServiceImpl(applicationsRepository);
        PhotosessionPlusPhotoService pppService = new PhotosessionPlusPhotoServiceImpl(pppRepository);

        servletContext.setAttribute("signUpService", signUpService);
        servletContext.setAttribute("signInService", signInService);
        servletContext.setAttribute("photoService", photoService);
        servletContext.setAttribute("photosessionService", photosessionService);
        servletContext.setAttribute("applicationService", applicationService);
        servletContext.setAttribute("pppService", pppService);
        servletContext.setAttribute("validator", validator);

        servletContext.setAttribute("imageDir", "C://files");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
