package com.project.experto.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.experto.models.Usuario;

@Controller
@RequestMapping(value = "/app")
public class IndexController {
    
    @GetMapping({"/index","/home"})
    public String index(Model model){
        model.addAttribute("titulo", "hola titulo!");
        return "index";
    }

    @GetMapping(value = "/perfil")
        String perfil (Model model){
            Usuario usuario = new Usuario();
            usuario.setNombre("Pepe");
            usuario.setApellido("Lopez");
            usuario.setEmail("usuario@correo.com");
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil del usuario: ".concat(usuario.getNombre()));

        return "perfil";
    }

    @GetMapping(value = "/listar")
    String listar (Model model){
        List<Usuario> usuarios = new ArrayList<>();
        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);

        return "listar";
    }
    
}
