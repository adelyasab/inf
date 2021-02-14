package ru.itis.spingbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.spingbootdemo.dto.PhotosessionDto;
import ru.itis.spingbootdemo.dto.PhotosessionDtoForRequest;
import ru.itis.spingbootdemo.services.PhotosessionsService;
import java.util.List;

@Controller
public class PhotosessionsController {

    @Autowired
    private PhotosessionsService photosessionsService;

    @GetMapping("/photosessions")
    public String getPhotosessionsPage(Model model) {
        return "all_photosessions_page";
    }


    @GetMapping("/photosessions/{type}/{price}")
    @ResponseBody
    public ResponseEntity<List<PhotosessionDto>> getPhotosessions(@PathVariable("type") String type,
                                           @PathVariable("price") String price) {
        if ((price != null) && (!type.startsWith("all"))){
            return ResponseEntity.ok(photosessionsService.getPhotosessions(type, Integer.parseInt(price)));
        } else if (price != null){
            return ResponseEntity.ok(photosessionsService.getPhotosessions(Integer.parseInt(price)));
        } else {
            return ResponseEntity.ok(photosessionsService.getAllPhotosessions());
        }
    }

    @GetMapping("/photosessions/{type}")
    @ResponseBody
    public ResponseEntity<List<PhotosessionDto>> getPhotosessions(@PathVariable("type") String type) {
        return getPhotosessions(type, null);
    }

    @PostMapping("/photosessions")
    public ResponseEntity<List<PhotosessionDto>> postPhotosessions(@RequestBody PhotosessionDtoForRequest photosessionDto) {
        return getPhotosessions(photosessionDto.getType(), photosessionDto.getPrice());
    }

}
