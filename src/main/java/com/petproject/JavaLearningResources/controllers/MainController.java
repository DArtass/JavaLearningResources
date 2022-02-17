package com.petproject.JavaLearningResources.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Trofimov Alexandr");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("info", "Age: 31. City: Samara");
        return "about";
    }
}