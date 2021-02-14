package ru.itis.spingbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.spingbootdemo.dto.UserForm;
import ru.itis.spingbootdemo.services.SignUpService;

@Controller
public class SignupController {

    @Autowired
    private SignUpService signUpService;

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "sign_up_page";
    }

    @PostMapping("/signUp")
    public String signUpPage(UserForm form) {
        signUpService.signUp(form);
        return "redirect:/signUp";
    }
}
