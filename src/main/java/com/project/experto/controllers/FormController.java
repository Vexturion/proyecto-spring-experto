package com.project.experto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formularios")
public class FormController {
    
    @GetMapping("/form")
    public String getForm(){
        return "formularios/form";
    }

    @PostMapping("/form")
    public String postForm(){
        return "formularios/resultado";
    }



}
