package com.example.gift.controller;

import com.example.gift.model.Internship;
import com.example.gift.service.InternService;
import com.example.gift.service.InternshipService;
import com.example.gift.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/internships")
public class InternshipController {

    private InternshipService internshipService;
    private TutorService tutorService;
    private InternService internService;

    InternshipController(InternshipService internshipService, TutorService tutorService, InternService internService){
        this.internshipService = internshipService;
        this.tutorService = tutorService;
        this.internService = internService;
    }

    @GetMapping(path = "")
    public String tutorInternships(Principal principal, Model model) {
        String tutorId = principal.getName();
        var internships = internshipService.getInternshipsFromTutorId(tutorId);
        model.addAttribute("internships", internships);
        return "internships";
    }

    @GetMapping(path = "/all")
    public String allInternships(@RequestParam Optional<String> query, Principal principal, Model model) {
        if (query.isPresent()){
            var internships = internshipService.search(query.get());
            model.addAttribute("internships", internships);
        } else {
            String tutorId = principal.getName();
            var internships = internshipService.getAll();
            model.addAttribute("internships", internships);
        }
        model.addAttribute("all", true);
        return "internships";
    }

    @GetMapping("/new")
    public String addInternshipFrom(Model model) {
        model.addAttribute("internship", new Internship());
        model.addAttribute("interns", internService.getAll());
        model.addAttribute("tutors", tutorService.getAll());
        return "internshipForm";
    }

    @GetMapping("/edit/{id}")
    public String editInternshipForm(@PathVariable Long id, Principal principal, Model model) {
        Internship internship = internshipService.one(id);
        model.addAttribute("internship", internship);
        model.addAttribute("interns", internService.getAll());
        model.addAttribute("tutors", tutorService.getAll());
        return "internshipForm";
    }

    @PostMapping("/save")
    public String addInternship(@Valid Internship internship, BindingResult bindingResult, RedirectAttributes redirectAttrs, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("interns", internService.getAll());
            model.addAttribute("tutors", tutorService.getAll());
            return "internshipForm";
        } else {
            internshipService.save(internship);
            var action = (internship.getId() == null) ? "créé": "modifié";
            redirectAttrs.addFlashAttribute("message", "Le stage a été " + action);
            return "redirect:/internships";
        }
    }

    @GetMapping  ("/delete/{id}")
    public String deleteInternship(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        internshipService.delete(id);
        redirectAttrs.addFlashAttribute("message", "Le stage a été supprimé");
        return "redirect:/internships";
    }
}