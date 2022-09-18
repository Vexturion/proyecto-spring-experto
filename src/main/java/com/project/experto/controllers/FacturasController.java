package com.project.experto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.experto.models.domain.Factura;

@Controller
@RequestMapping("/facturas")
public class FacturasController {

    @Autowired
    private Factura factura;

    @Value("${texto.facturascontroller.facturas.titulo: titulo}")
    public String titulo;
    
    @GetMapping("/ver")
    public String ver(Model model){
        model.addAttribute("factura", factura);
        model.addAttribute(titulo, "Ejemplo factura con inyeccion de dependencias");
        return "facturas/ver";
    }

}