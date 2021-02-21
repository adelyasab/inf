package ru.itis.spingbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.spingbootdemo.services.UsersService;

@Controller
public class ConfirmController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/confirm/{code}")
    public String confirmUser(@PathVariable("code") String code, Model model) {
        usersService.confirmUserWithCode(code);
        model.addAttribute("name", usersService.getNameByCode(code));
        return "confirm";
    }
}
