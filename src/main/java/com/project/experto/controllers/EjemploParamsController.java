package com.project.experto.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/string")
    public String param(@RequestParam(required = false, defaultValue = "Aqui no hay nada") String texto, Model model) {
        model.addAttribute("resultado", "el texto enviado es: '" + texto);
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String param(@RequestParam String texto, @RequestParam int numero, Model model) {
        model.addAttribute("resultado", "el texto enviado es: '" + texto + "' y el numero enviado es: " + numero);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model) {
        String texto = request.getParameter("Hola como estas");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
            System.out.println(e);
        }
        model.addAttribute("resultado", "el texto enviado es: '" + texto + "' y el numero enviado es: " + numero);
        return "params/ver";
    }

    @GetMapping("/")
    public String index() {
        return "params/index";
    }

}
