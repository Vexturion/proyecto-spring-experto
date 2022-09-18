package com.project.experto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/formularios")
public class FormController {
    
    @GetMapping("/form")
    public String getForm(Model model ){
        return "formularios/form";
    }

    @PostMapping("/form")
    public String postForm(Model model, @RequestParam String username,
    @RequestParam String password,
    @RequestParam String email){

        model.addAttribute("titulo", "resultado del formulario");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);

        return "formularios/resultado";
    }



}
