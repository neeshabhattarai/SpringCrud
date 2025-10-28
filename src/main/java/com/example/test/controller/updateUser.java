package com.example.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test.Service.userService;
import com.example.test.pojo.User;
import com.example.test.repository.userCrud;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Controller
public class updateUser {
    @Autowired
    private userCrud userCrud;
    @Autowired
    private userService service;

    @GetMapping("/updateForm")
    public String getMethodName(Authentication authentication, Model model, HttpSession session,
            @RequestParam(value = "name", required = false) String name) {
        List<User> user = userCrud.findByUserName(name);
        User details = user.get(0);
        // log.info(details.toString());
        session.setAttribute("user", details);
        model.addAttribute("user", details);
        return "updateform.html";
    }

    @PostMapping("/updateUser")
    public String postMethodName(@Valid @ModelAttribute("user") User user, HttpSession session) {
        // log.info(session.getAttribute("user").toString());
        int value = service.updateForm(user, session);
        session.invalidate();
        // log.info(String.valueOf(value));
        return "redirect:/login";
    }

}
