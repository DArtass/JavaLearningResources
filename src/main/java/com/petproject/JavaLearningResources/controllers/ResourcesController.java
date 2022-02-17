package com.petproject.JavaLearningResources.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResourcesController {

    @GetMapping("/allresources")
    public String allResources(Model model) {
        return "allresources";
    }
}
