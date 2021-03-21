package ru.itis.spingbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.spingbootdemo.security.details.UserDetailsImpl;

@Controller
public class ProfileController {
    @GetMapping("/profile")
    public String getProfile(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        model.addAttribute("userName", userDetails.getUsername());
        return "profile_page";
    }
}
