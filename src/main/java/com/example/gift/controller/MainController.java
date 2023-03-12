package com.example.gift.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(path = "/error")
    public String handleError() {
        return "error";
    }

    @GetMapping(path = "/")
    public String home() {
        return "redirect:/internships";
    }
}