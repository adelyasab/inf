package ru.itis.spingbootdemo.controllers;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.spingbootdemo.dto.UserDto;
import ru.itis.spingbootdemo.services.UsersService;

@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("userlist", usersService.getAllUsers());
        return "users_page";
    }

    @GetMapping("/users/{user-id}")
    @ResponseBody
    public ResponseEntity<UserDto> getUser(@PathVariable("user-id") Long userId) {
        return ResponseEntity.ok(usersService.getUser(userId));
    };
}
