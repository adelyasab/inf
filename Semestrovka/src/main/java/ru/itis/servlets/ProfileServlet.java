package ru.itis.servlets;

import ru.itis.models.*;
import ru.itis.services.ApplicationService;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
@MultipartConfig
public class ProfileServlet extends HttpServlet{

    private PhotoService photoService;
    private PhotosessionService photosessionService;
    private ApplicationService applicationService;
    private PhotosessionPlusPhotoService photosessionPlusPhotoService;

    @Override
    public void init(ServletConfig config){
        this.photoService = (PhotoService) config.getServletContext().getAttribute("photoService");
        this.photosessionService = (PhotosessionService) config.getServletContext().getAttribute("photosessionService");
        this.applicationService = (ApplicationService) config.getServletContext().getAttribute("applicationService");
        this.photosessionPlusPhotoService = (PhotosessionPlusPhotoService) config.getServletContext().getAttribute("pppService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Photo photo = photoService.getFileInfo(user.getMainPhotoId());
        List<Photosession> photosessions = photosessionService.getPhotosessionsWithUserId(user.getId());
        List<PhotosessionPlusPhoto> photosessionPlusPhotos = photosessionPlusPhotoService.findAll();
        Integer ps = photosessions.size();
        Integer submittedApplications = applicationService.getApplicationByCustomerId(user.getId()).size();
        Integer adoptedApplications = applicationService.getAllByWhomCustomerId(user.getId()).size();
        request.setAttribute("userForProfile", user);
        request.setAttribute("photoOfProfile", photo);
        request.setAttribute("photosessions", ps);
        request.setAttribute("submittedApplication", submittedApplications);
        request.setAttribute("adoptedApplication", adoptedApplications);
        request.setAttribute("photosessionsPlusPhotos", photosessionPlusPhotos);
        request.setAttribute("photosessionsForProfile", photosessions);
        request.getRequestDispatcher("WEB-INF/jsp/profile.jsp").forward(request, response);
    }
}
