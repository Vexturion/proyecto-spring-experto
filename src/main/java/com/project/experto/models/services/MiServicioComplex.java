package com.project.experto.models.services;

import org.springframework.stereotype.Service;

// tambien podemos usar qualifier para indicar que queremos inyectar este servicio y no el primario
@Service("miServicioComplex") // hay que darle un nombre a la anotacion service
public class MiServicioComplex implements IServicio {

    public MiServicioComplex() {
    }

    @Override
    public String operacion() {
        return "Ejecutando algun proceso complejo";
    }


 
}
