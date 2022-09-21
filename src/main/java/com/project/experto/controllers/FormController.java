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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.project.experto.models.domain.Usuario;

@Controller
@SessionAttributes("usuario")
@RequestMapping("/formularios")
public class FormController {

    @GetMapping("/form")
    public String obtenerForm(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Julio Profe");
        usuario.setId(1);
        model.addAttribute("titulo", "Formulario de usuarios");
        model.addAttribute("usuario", usuario);

        return "formularios/form";
    }

    @PostMapping("/form")
    public String procesarForm(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus sessionStatus) {

        model.addAttribute("titulo", "resultado del formulario");

        if (result.hasErrors()) {
            /* Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo ".concat(err.getField().concat(" ").concat(err.getDefaultMessage())));
            });
            model.addAttribute("error", errores); */
            return "formularios/form";
        }

        model.addAttribute("usuario", usuario);
        sessionStatus.setComplete();

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
