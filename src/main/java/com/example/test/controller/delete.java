package com.example.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.test.Service.userService;

@Controller
public class delete {
    @Autowired
    private userService service;

    @GetMapping("/delete")
    public String getMethodName(@RequestParam(value = "id", required = true) String param) {
        service.deleteUser(param);
        return "redirect:/";
    }

}
