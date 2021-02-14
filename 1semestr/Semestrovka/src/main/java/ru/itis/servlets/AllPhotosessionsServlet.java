package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.models.HelperInAllPhotosession;
import ru.itis.models.Photo;
import ru.itis.models.Photosession;
import ru.itis.services.PhotoService;
import ru.itis.services.PhotosessionService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/allPhotosession")
@MultipartConfig
public class AllPhotosessionsServlet extends HttpServlet {

    private PhotoService photoService;
    private PhotosessionService photosessionService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) {
        this.photoService = (PhotoService) config.getServletContext().getAttribute("photoService");
        this.photosessionService = (PhotosessionService) config.getServletContext().getAttribute("photosessionService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //получили инфо о файле
        //Photo photo = photoService.getFileInfo(Long.parseLong(fileId));
        // в ответ указали тип данных
        //response.setContentType(photo.getType());
        // в ответ указали какой размер данных
        //response.setContentLength(photo.getSize().intValue());
        // указали ориг назв
        //response.setHeader("Content-Disposition", "filename=\"" +photo.getOriginFileName() + "\"");
        //данные файла в ответ
        //photoService.writeFileFromStorage(Long.parseLong(fileId), response.getOutputStream());
        //response.flushBuffer();
        request.getRequestDispatcher("/WEB-INF/jsp/all_photosessions.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws IOException {
        Photosession photosession = objectMapper.readValue(request.getReader(), Photosession.class);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        List<HelperInAllPhotosession> helperInAllPhotosession = new ArrayList<>();
        List<Photosession> photosessions;
        if (!photosession.getType().equals("all")) {
            photosessions = photosessionService.findAllCheaperAndType(photosession.getPrice(), photosession.getType());
        } else {
            photosessions = photosessionService.findAllCheaper(photosession.getPrice());
        }
        for (Photosession i: photosessions) {
            Photo photo = photoService.getFileInfo(i.getIdMainPhoto());
            helperInAllPhotosession.add(HelperInAllPhotosession.builder().photo_type(photo.getType()).
            photo_storage_name(photo.getStorageFileName()).id(i.getId()).photosession_name(i.getName()).build());
        }
        response.getWriter().println(objectMapper.writeValueAsString(helperInAllPhotosession));
    }
}
