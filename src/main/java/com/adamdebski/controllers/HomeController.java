package com.adamdebski.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String homePage(Model model, Principal principal, Authentication authenticaton) {
        System.out.println("inside '/', pricipal = " + principal + " authentication = " + authenticaton);
        return "home";
    }


    @GetMapping("/login")
    public String loginPage(Model model, Principal principal) {
        System.out.println("inside /login " + principal);
        return "home";
    }
}
