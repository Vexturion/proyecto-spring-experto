package com.project.experto.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.experto.models.domain.Usuario;

@Controller
@RequestMapping("/formularios")
public class FormController {

    @GetMapping("/form")
    public String getForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("titulo", "Formulario de usuarios");
        model.addAttribute("usuario", usuario);
        return "formularios/form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {
            /* Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
            });
            model.addAttribute("error", errores); */
            return "formularios/form";
        }

        model.addAttribute("titulo", "resultado del formulario");
        model.addAttribute("usuario", usuario);

        return "formularios/resultado";
    }

    /*
     * @PostMapping("/form")
     * public String postForm(Model model, @RequestParam String username,
     * 
     * @RequestParam String password,
     * 
     * @RequestParam String email){
     * 
     * Usuario usuario = new Usuario();
     * usuario.setUsername(username);
     * usuario.setPassword(password);
     * usuario.setEmail(email);
     * 
     * model.addAttribute("titulo", "resultado del formulario");
     * model.addAttribute("usuario", usuario);
     * 
     * return "formularios/resultado";
     */
    // }

}
