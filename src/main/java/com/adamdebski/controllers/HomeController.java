package com.adamdebski.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	
    @GetMapping("/")
    public String homePage(Model model, Principal principal) {
	System.out.println("inside / " + principal);
        return "home";
    }
    
    @GetMapping("/login")
    public String loginPage(Model model, Principal principal) {
	System.out.println("inside /login");
    	return "home";
    }
}
