package com.petproject.JavaLearningResources.controllers;

import com.petproject.JavaLearningResources.models.Resource;
import com.petproject.JavaLearningResources.repo.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ResourcesController {

    @Autowired
    private ResourceRepository resourceRepository;

    @GetMapping("/allresources")
    public String allResources(Model model) {
        Iterable<Resource> resources = resourceRepository.findAll();
        model.addAttribute("resources", resources);
        return "allresources";
    }

    @GetMapping("/resource/add")
    public String resourceAdd(Model model) {
        return "resourceAdd";
    }

    @PostMapping("/resource/add")
    public String resourceNewAdd(@RequestParam String name, @RequestParam String type, @RequestParam String link, @RequestParam int useful, @RequestParam String description, Model model) {
        Resource resource = new Resource(name, description, link, type, useful);
        resourceRepository.save(resource);
        return "redirect:/allresources";
    }

    @GetMapping("/resource/{id}/edit")
    public String resourceEdit(@PathVariable(value = "id") long id, Model model) {
        if(!resourceRepository.existsById(id)){
            return "redirect:/allresources";
        }
        Optional<Resource> resource = resourceRepository.findById(id);
        ArrayList<Resource> res = new ArrayList<>();
        resource.ifPresent(res::add);
        model.addAttribute("resource", res);
        return "resourceEdit";
    }

    @PostMapping("/resource/{id}/edit")
    public String resourceUpdate(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String type, @RequestParam String link, @RequestParam int useful, @RequestParam String description, Model model) {
        Resource resource = resourceRepository.findById(id).orElseThrow();
        resource.setName(name);
        resource.setType(type);
        resource.setLink(link);
        resource.setUseful(useful);
        resource.setDescription(description);
        resourceRepository.save(resource);
        return "redirect:/allresources";
    }

    @PostMapping("/resource/{id}/remove")
    public String resourceURemove(@PathVariable(value = "id") long id, Model model) {
        Resource resource = resourceRepository.findById(id).orElseThrow();
        resourceRepository.delete(resource);
        return "redirect:/allresources";
    }
}
