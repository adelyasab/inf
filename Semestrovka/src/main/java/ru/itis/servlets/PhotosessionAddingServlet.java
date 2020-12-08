package ru.itis.servlets;

import ru.itis.dto.PhotoForm;
import ru.itis.dto.PhotosessionForm;
import ru.itis.models.PhotosessionPlusPhoto;
import ru.itis.models.User;
import ru.itis.services.PhotoService;
import ru.itis.services.PhotosessionPlusPhotoService;
import ru.itis.services.PhotosessionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.validation.Validator;
import java.io.IOException;

@WebServlet("/addingPhotosession")
@MultipartConfig
public class PhotosessionAddingServlet  extends HttpServlet {

    private PhotoService photoService;
    private PhotosessionService photosessionService;
    private PhotosessionPlusPhotoService pppService;
    Validator validator;

    @Override
    public void init(ServletConfig config){
        this.photoService = (PhotoService) config.getServletContext().getAttribute("photoService");
        this.pppService = (PhotosessionPlusPhotoService) config.getServletContext().getAttribute("pppService");
        this.validator = (Validator) config.getServletContext().getAttribute("validator");
        this.photosessionService = (PhotosessionService) config.getServletContext().getAttribute("photosessionService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/jsp/adding_photosession.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        User user = (User) request.getSession().getAttribute("user");

        PhotoForm photoForm = PhotoForm.builder()
                .originFileName(part.getSubmittedFileName())
                .size(part.getSize())
                .type(part.getContentType())
                .idPhotosession(0L)
                .build();
        Long id_photo = photoService.savePhotoToStorage(part.getInputStream(), photoForm);
        PhotosessionForm photosessionForm = PhotosessionForm.builder()
                                            .name(request.getParameter("name"))
                                            .idUser(user.getId())
                                            .type(request.getParameter("type_photo"))
                                            .idMainPhoto(id_photo)
                                            .price(Integer.parseInt(request.getParameter("price")))
                                            .build();
        Long id_photosession = photosessionService.savePhotosessionToStorage(photosessionForm);
        pppService.save(PhotosessionPlusPhoto.builder().idPhotoset(id_photosession).
                storageName(photoService.getFileInfo(id_photo).getStorageFileName()).
                type(part.getContentType()).build());
        photoService.changePhotosessionById(id_photo, id_photosession);
        response.sendRedirect("/uploading?photosession=" + id_photosession.toString());
    }
}