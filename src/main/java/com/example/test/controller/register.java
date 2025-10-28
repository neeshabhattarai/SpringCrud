package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test.Service.userService;
import com.example.test.pojo.User;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class register {
    @Autowired
    private userService service;
    @Autowired
    private PasswordEncoder encoder;

    public register(userService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public String getUSer(@Valid User user, Errors error) {
        log.info("UserName " + user.getUserName());
        if (error.hasErrors()) {
            return "register.html";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        int value = service.saveUser(user);
        if (value > 0) {
            log.info("User Saved successfully");
        }

        return "redirect:/test";
    }

    @RequestMapping(value = "/newuser", method = RequestMethod.GET)
    public String displaySignUp(Model model) {
        model.addAttribute("user", new User());

        return "register.html";
    }

}
