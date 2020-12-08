package ru.itis.servlets;

import ru.itis.dto.PhotoForm;
import ru.itis.dto.UserForm;
import ru.itis.services.PhotoService;
import ru.itis.services.SignUpService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

@WebServlet("/signUp")
@MultipartConfig
public class SignUpServlet extends HttpServlet {

    private SignUpService signUpService;
    private PhotoService photoService;
    private Validator validator;

    @Override
    public void init(ServletConfig config){
        ServletContext context = config.getServletContext();
        this.signUpService = (SignUpService) context.getAttribute("signUpService");
        this.photoService = (PhotoService) context.getAttribute("photoService");
        this.validator = (Validator) context.getAttribute("validator");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/sign_up.jsp").forward(req, resp);
        req.setAttribute("errors", new ArrayList<>());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        PhotoForm photoForm = PhotoForm.builder()
                .type(part.getContentType())
                .size(part.getSize())
                .originFileName(part.getSubmittedFileName())
                .idPhotosession(0L)
                .build();
        Long id_photo = photoService.savePhotoToStorage(part.getInputStream(), photoForm);
        UserForm userForm = UserForm.builder().
                email(request.getParameter("email")).
                password(request.getParameter("password")).
                firstName(request.getParameter("firstName")).
                lastName(request.getParameter("lastName")).
                mainPhotoId(id_photo).
                build();
        Set<ConstraintViolation<UserForm>> constraintViolations = validator.validate(userForm);
        if (!constraintViolations.isEmpty()) {
            request.setAttribute("errors", constraintViolations);
            request.getRequestDispatcher("WEB-INF/jsp/sign_up.jsp").forward(request, response);
        } else {
            signUpService.signUp(userForm);
            response.sendRedirect("/signIn");
        }
    }
}
