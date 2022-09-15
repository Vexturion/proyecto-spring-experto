package com.project.experto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping("/")
    public String home(){
        return "forward:/app/index";
        // tambien podemos usar redirect, redirect cambia la peticion de http, la reinicia. Para una pagina de inicio forward seria la mejor opcion
    }
}