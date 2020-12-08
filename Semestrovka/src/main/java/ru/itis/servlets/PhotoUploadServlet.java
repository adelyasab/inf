package ru.itis.servlets;
import ru.itis.dto.PhotoForm;
import ru.itis.models.PhotosessionPlusPhoto;
import ru.itis.services.PhotoService;
import ru.itis.services.PhotosessionPlusPhotoService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/uploading")
@MultipartConfig
public class PhotoUploadServlet extends HttpServlet {

    private PhotoService photoUploadService;
    Long photosessionId;
    private PhotosessionPlusPhotoService pppService;

    @Override
    public void init(ServletConfig config) {
        this.photoUploadService = (PhotoService) config.getServletContext().getAttribute("photoService");
        this.pppService = (PhotosessionPlusPhotoService) config.getServletContext().getAttribute("pppService");

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        photosessionId = Long.parseLong(request.getParameter("photosession"));
        request.setAttribute("photosession_id", photosessionId);
        request.getRequestDispatcher("WEB-INF/jsp/file_upload.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("file");
        PhotoForm photoForm = PhotoForm.builder()
                .type(part.getContentType())
                .size(part.getSize())
                .originFileName(part.getSubmittedFileName())
                .idPhotosession(photosessionId)
                .build();
        Long photoId = photoUploadService.savePhotoToStorage(part.getInputStream(), photoForm);
        pppService.save(PhotosessionPlusPhoto.builder().idPhotoset(photosessionId).
                storageName(photoUploadService.getFileInfo(photoId).getStorageFileName()).
                type(part.getContentType()).build());

        response.sendRedirect("/uploading?photosession=" + photosessionId.toString());
    }
}
