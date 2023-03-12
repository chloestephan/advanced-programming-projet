package com.example.gift.controller.rest;

import java.util.List;

import com.example.gift.model.Intern;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gift.service.InternService;
@RestController
class InternRestController {
    private InternService internService;

    InternRestController(InternService internService){
        this.internService = internService;
    }
    @GetMapping("/api/interns")
    List<Intern> all() {
        return internService.getAll();
    }
}
