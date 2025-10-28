package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.test.Service.userService;

@Controller
public class list {
    @Autowired
    private userService service;

    @GetMapping("/")
    public String getMethodName(Model model) {
        model.addAttribute("user", service.allUser());
        return "main.html";
    }

    @GetMapping("/test")
    public String Details(Model model, Authentication authentication) {
        model.addAttribute("role", authentication.getAuthorities());
        return "test.html";
    }

}
