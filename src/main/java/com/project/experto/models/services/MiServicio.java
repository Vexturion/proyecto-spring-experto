package com.project.experto.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

// las clases service-component deberan de cumplir con ciertas caracteristicas, tener un constructor vacio
// ademas del constructor con parametros
@Primary //resuelve el problema de que existan dos servicios que implementan la misma interface, Spring no sabra
// cual es el servicio que debe inyectar, con @Primary establecemos uno por default
@Service
public class MiServicio implements IServicio {

    public MiServicio() {
    }

    @Override
    public String operacion() {
        return "Ejecutando algun proceso importante...";
    }
    
    

}
