package ru.itis.servlets;

import ru.itis.dto.ApplicationForm;
import ru.itis.dto.UserForm;
import ru.itis.models.Photosession;
import ru.itis.models.User;
import ru.itis.services.ApplicationService;
import ru.itis.services.PhotosessionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet("/application")
public class ApplicationServlet extends HttpServlet {

    Long photosessionId;
    ApplicationService applicationService;
    PhotosessionService photosessionService;
    Validator validator;

    @Override
    public void init(ServletConfig config){
        ServletContext context = config.getServletContext();
        this.applicationService = (ApplicationService) context.getAttribute("applicationService");
        this.photosessionService = (PhotosessionService) config.getServletContext().getAttribute("photosessionService");
        this.validator = (Validator) context.getAttribute("validator");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        photosessionId = Long.parseLong(request.getParameter("photosession"));
        request.setAttribute("photosession_id", photosessionId);
        request.setAttribute("errors", new ArrayList<>());
        request.getRequestDispatcher("WEB-INF/jsp/application.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Photosession photosession = photosessionService.getUserIdByPhotosession(photosessionId).get();

        User user = (User) request.getSession().getAttribute("user");
        ApplicationForm applicationForm = ApplicationForm.builder().
                date(request.getParameter("date")).
                time(request.getParameter("time")).
                customerId(user.getId()).
                photosessionId(photosessionId).
                phoneNumber(request.getParameter("phonenumber")).
                name(request.getParameter("name")).
                photosessionByUserId(photosession.getIdUser()).
                build();
        Set<ConstraintViolation<ApplicationForm>> constraintViolations = validator.validate(applicationForm);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<ApplicationForm> constraintViolation: constraintViolations) {
                System.out.println(constraintViolation.getMessage());
            }
            request.setAttribute("errors", constraintViolations);
            request.getRequestDispatcher("WEB-INF/jsp/application.jsp").forward(request, response);
        } else {
            applicationService.giveApplication(applicationForm);
            response.sendRedirect("/profile");
        }

    }
}
